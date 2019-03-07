package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.helper.PosLog;
import com.model.MenuCategory;
import com.model.MenuGroup;
import com.model.MenuItem;
import com.model.MenuItemModifierGroup;
import com.model.Modifier;
import com.model.ModifierGroup;
import com.model.Tax;
import com.model.TaxGroup;
import com.resources.Elements;
import com.resources.Response;
import com.service.MenuCategoryService;
import com.service.MenuGroupService;
import com.service.MenuItemModifierGroupService;
import com.service.MenuItemService;
import com.service.ModifierGroupService;
import com.service.ModifierService;
import com.service.TaxService;

@RestController
public class MenusImportExportController {

	@Autowired
	MenuCategoryService menuCategoryService;
	@Autowired
	MenuGroupService menuGroupService;
	@Autowired
	MenuItemService menuItemService;
	@Autowired
	MenuItemModifierGroupService menuItemModifierGroupService;
	@Autowired
	ModifierGroupService modifierGroupService;
	@Autowired
	ModifierService modifierService;
	@Autowired
	TaxService taxService;

	@RequestMapping(value = "/createDefaultMenus/", method = RequestMethod.POST)
	@ExceptionHandler({ Exception.class })
	public Response createDefaultMenus() throws Exception {
		Map<String, Object> objectMap = new HashMap<String, Object>();
		InputStream inputStream = null;
		try {
			inputStream = MenusImportExportController.class.getResourceAsStream("/default-menu-items.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Elements.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Elements elements = (Elements) unmarshaller.unmarshal(inputStream);

			List<Tax> taxes = elements.getTaxes();
			if (taxes != null) {
				for (Tax tax : taxes) {
					objectMap.put(tax.getUniqueId(), tax);
					taxService.saveOrUpdate(tax);
					PosLog.debug(MenusImportExportController.class, tax.getName());
				}
			}

			List<MenuCategory> menuCategories = elements.getMenuCategories();
			if (menuCategories != null) {
				for (MenuCategory menuCategory : menuCategories) {
					objectMap.put(menuCategory.getUniqueId(), menuCategory);
					menuCategoryService.saveOrUpdate(menuCategory);
					PosLog.debug(MenusImportExportController.class, menuCategory.getName());
				}
			}

			List<MenuGroup> menuGroups = elements.getMenuGroups();
			if (menuGroups != null) {
				for (MenuGroup menuGroup : menuGroups) {
					MenuCategory menuCategory = menuGroup.getParent();
					if (menuCategory != null) {
						menuCategory = (MenuCategory) objectMap.get(menuCategory.getUniqueId());
						menuGroup.setParent(menuCategory);
					}
					objectMap.put(menuGroup.getUniqueId(), menuGroup);
					menuGroupService.saveOrUpdate(menuGroup);
					PosLog.debug(MenusImportExportController.class, menuGroup.getName());
				}
			}

			List<ModifierGroup> modifierGroups = elements.getModifierGroups();
			if (modifierGroups != null) {
				for (ModifierGroup modifierGroup : modifierGroups) {
					objectMap.put(modifierGroup.getUniqueId(), modifierGroup);
					modifierGroupService.saveOrUpdate(modifierGroup);
					PosLog.debug(MenusImportExportController.class, modifierGroup.getName());
				}
			}

			List<Modifier> modifiers = elements.getMenuModifiers();
			if (modifiers != null) {
				for (Modifier modifier : modifiers) {
					objectMap.put(modifier.getUniqueId(), modifier);
					ModifierGroup modifierGroup = modifier.getModifierGroup();
					if (modifierGroup != null) {
						modifierGroup = (ModifierGroup) objectMap.get(modifierGroup.getUniqueId());
						modifier.setModifierGroup(modifierGroup);
					}

					Tax tax = modifier.getTax();
					if (tax != null) {
						tax = (Tax) objectMap.get(tax.getUniqueId());
						modifier.setTax(tax);
					}
					modifierService.saveOrUpdate(modifier);
					PosLog.debug(MenusImportExportController.class, modifier.getName());
				}
			}

			List<MenuItemModifierGroup> menuItemModifierGroups = elements.getMenuItemModifierGroups();
			if (menuItemModifierGroups != null) {
				for (MenuItemModifierGroup mimg : menuItemModifierGroups) {
					objectMap.put(mimg.getUniqueId(), mimg);

					ModifierGroup ModifierGroup = mimg.getModifierGroup();
					if (ModifierGroup != null) {
						ModifierGroup = (ModifierGroup) objectMap.get(ModifierGroup.getUniqueId());
						mimg.setModifierGroup(ModifierGroup);
					}
					menuItemModifierGroupService.saveOrUpdate(mimg);
					PosLog.debug(MenusImportExportController.class, mimg.getUniqueId());
				}
			}

			List<MenuItem> menuItems = elements.getMenuItems();
			if (menuItems != null) {
				for (MenuItem menuItem : menuItems) {
					objectMap.put(menuItem.getUniqueId(), menuItem);
					MenuGroup menuGroup = menuItem.getParent();
					if (menuGroup != null) {
						menuGroup = (MenuGroup) objectMap.get(menuGroup.getUniqueId());
						menuItem.setParent(menuGroup);
					}

					TaxGroup taxGroup = menuItem.getTaxGroup();
					if (taxGroup != null) {
						taxGroup = (TaxGroup) objectMap.get(taxGroup.getTax());
						menuItem.setTaxGroup(taxGroup);
					}

					List<MenuItemModifierGroup> menuItemModiferGroups = menuItem.getMenuItemModifierGroup();
					if (menuItemModiferGroups != null) {
						for (MenuItemModifierGroup menuItemModifierGroup : menuItemModiferGroups) {
							MenuItemModifierGroup menuItemModifierGroup2 = (MenuItemModifierGroup) objectMap.get(menuItemModifierGroup.getUniqueId());
							menuItemModifierGroup.setId(menuItemModifierGroup2.getId());
							menuItemModifierGroup.setModifierGroup(menuItemModifierGroup2.getModifierGroup());
						}
					}
					menuItemService.saveOrUpdate(menuItem);
					PosLog.debug(MenusImportExportController.class, menuItem.getName());
				}
			}

		} catch (IOException e) {
			return new Response("err", "File not found!");
		} catch (Exception e) {
			return new Response("err", "Unexpected error!");
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
		return new Response("ok", "Default menus are created successfull.");
	}
}
