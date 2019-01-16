/**
 * ************************************************************************
 * * The contents of this file are subject to the MRPL 1.2
 * * (the  "License"),  being   the  Mozilla   Public  License
 * * Version 1.1  with a permitted attribution clause; you may not  use this
 * * file except in compliance with the License. You  may  obtain  a copy of
 * * the License at http://www.softpos.org/license.html
 * * Software distributed under the License  is  distributed  on  an "AS IS"
 * * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * * License for the specific  language  governing  rights  and  limitations
 * * under the License.
 * * The Original Code is SOFT POS.
 * * All Rights Reserved.
 * ************************************************************************
 */
package com.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "MODIFIER_GROUP")
public class ModifierGroup {
	public final static String MODIFIER_GROUP_ID = "modifierGroupId";
	public final static String MODIFIER_GROUP_NAME = "name";
	public final static String MODIFIER_GROUP_TRANSLATED_NAME = "translatedName";
	public final static String MODIFIER_GROUP_ENABLED = "enable";
	public final static String MODIFIER_GROUP_EXCLUSIVED = "exclusive";
	public final static String MODIFIER_GROUP_REQUIRED = "required";
	public final static String MODIFIER = "modifier";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = MODIFIER_GROUP_ID, unique = true, nullable = false)
	private Integer modifierGroupId;

	@Column(name = MODIFIER_GROUP_NAME)
	private String name;

	@Column(name = MODIFIER_GROUP_TRANSLATED_NAME)
	private String translatedName;

	@Column(name = MODIFIER_GROUP_ENABLED)
	private Boolean enable;

	@Column(name = MODIFIER_GROUP_EXCLUSIVED)
	private Boolean exclusive;

	@Column(name = MODIFIER_GROUP_REQUIRED)
	private Boolean required;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = MODIFIER)
	private Set<Modifier> modifier;

	public ModifierGroup() {
	}

	/**
	 * @return the id
	 */
	public Integer getModifierGroupId() {
		return modifierGroupId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setModifierGroupId(Integer id) {
		this.modifierGroupId = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the translatedName
	 */
	public String getTranslatedName() {
		return translatedName;
	}

	/**
	 * @param translatedName
	 *            the translatedName to set
	 */
	public void setTranslatedName(String translatedName) {
		this.translatedName = translatedName;
	}

	/**
	 * @return the groupEnables
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * @param groupEnables
	 *            the groupEnables to set
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	/**
	 * @return the exlusive
	 */
	public Boolean getExclusive() {
		return exclusive;
	}

	/**
	 * @param exlusive
	 *            the exlusive to set
	 */
	public void setExclusive(Boolean exlusive) {
		this.exclusive = exlusive;
	}

	/**
	 * @return the required
	 */
	public Boolean getRequired() {
		return required;
	}

	/**
	 * @param required
	 *            the required to set
	 */
	public void setRequired(Boolean required) {
		this.required = required;
	}

	/**
	 * @return the modifier
	 */
	public Set<Modifier> getModifier() {
		return modifier;
	}

	/**
	 * @param modifier
	 *            the modifier to set
	 */
	public void setModifier(Set<Modifier> modifier) {
		this.modifier = modifier;
	}

	public String getUniqueId() {
		return ("menu_modifiergroup_" + getName() + "_" + getModifierGroupId()).replaceAll("\\s+", "_");
	}
}
