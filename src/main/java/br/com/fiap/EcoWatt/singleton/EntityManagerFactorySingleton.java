package br.com.fiap.EcoWatt.singleton;

import java.beans.PersistenceDelegate;

public class EntityManagerFactorySingleton {

	private static Class<PersistenceDelegate> unico;

	private EntityManagerFactorySingleton() {}

	public static Class<PersistenceDelegate> getInstance() {
		if (unico == null)
			unico = PersistenceDelegate.class;
		return unico;
	}

}