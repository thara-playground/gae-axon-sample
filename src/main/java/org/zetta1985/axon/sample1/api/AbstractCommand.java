package org.zetta1985.axon.sample1.api;

/**
 * Command 基底クラス。
 * Axon Frameworkでは、CommandはPOJOとして実装できる。
 * 
 * @author t_hara
 */
public abstract class AbstractCommand {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}