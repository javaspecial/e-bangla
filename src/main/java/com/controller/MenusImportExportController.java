package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.MenuCategory;
import com.model.MenuGroup;
import com.model.MenuItem;
import com.model.MenuItemModifierGroup;
import com.model.Modifier;
import com.model.ModifierGroup;
import com.model.Tax;
import com.model.TaxGroup;
import com.resources.Elements;
import com.service.MenuCategoryService;
import com.service.MenuGroupService;
import com.service.MenuItemModifierGroupService;
import com.service.MenuItemService;
import com.service.ModifierGroupService;
import com.service.ModifierService;
import com.service.TaxService;

@Controller
public class MenusImportExportController {

	private static final Logger logger = Logger.getLogger(MenusImportExportController.class);

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

	@RequestMapping(value = "/createDefaultMenus", method = RequestMethod.POST)
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public ResponseEntity<String> createDefaultMenus(ModelMap model) {
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
					tax.setTaxId(null);
					taxService.save(tax);
				}
			}

			List<MenuCategory> menuCategories = elements.getMenuCategories();
			if (menuCategories != null) {
				for (MenuCategory menuCategory : menuCategories) {
					String uniqueId = menuCategory.getUniqueId();
					objectMap.put(uniqueId, menuCategory);
					menuCategory.setId(null);
					menuCategoryService.save(menuCategory);
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
					menuGroup.setGroupId(null);
					menuGroupService.save(menuGroup);
				}
			}

			List<ModifierGroup> modifierGroups = elements.getModifierGroups();
			if (modifierGroups != null) {
				for (ModifierGroup ModifierGroup : modifierGroups) {
					objectMap.put(ModifierGroup.getUniqueId(), ModifierGroup);
					ModifierGroup.setModifierGroupId(null);
					modifierGroupService.save(ModifierGroup);
				}
			}

			List<Modifier> modifiers = elements.getMenuModifiers();
			if (modifiers != null) {
				for (Modifier modifier : modifiers) {
					objectMap.put(modifier.getUniqueId(), modifier);
					modifier.setModifierId(null);

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

					modifierService.save(modifier);
				}
			}

			List<MenuItemModifierGroup> menuItemModifierGroups = elements.getMenuItemModifierGroups();
			if (menuItemModifierGroups != null) {
				for (MenuItemModifierGroup mimg : menuItemModifierGroups) {
					objectMap.put(mimg.getUniqueId(), mimg);
					mimg.setId(null);

					ModifierGroup ModifierGroup = mimg.getModifierGroup();
					if (ModifierGroup != null) {
						ModifierGroup = (ModifierGroup) objectMap.get(ModifierGroup.getUniqueId());
						mimg.setModifierGroup(ModifierGroup);
					}
					menuItemModifierGroupService.save(mimg);
				}
			}

			List<MenuItem> menuItems = elements.getMenuItems();
			if (menuItems != null) {
				for (MenuItem menuItem : menuItems) {
					objectMap.put(menuItem.getUniqueId(), menuItem);
					menuItem.setMenuItemId(null);

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
					menuItemService.save(menuItem);
				}
			}

		} catch (IOException e) {
			logger.error("File not found exception:" + e.getMessage().toString());
			return new ResponseEntity<String>("File not found!", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error("Unexpected error:" + e.getMessage().toString());
			return new ResponseEntity<String>("Unexpected error!", HttpStatus.BAD_REQUEST);
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
		logger.debug("Default menus are created succesfull.");
		return new ResponseEntity<String>("Default menus are created successfull.", HttpStatus.OK);
	}
}
