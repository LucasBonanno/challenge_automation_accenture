package br.com.accenture.challenge.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Classe que efetua leitura de chaves do arquivo 'config.properties'.
 * 
 * @author Lucas Bonanno Casanova
 * @consutoria Inmetrics S/A
 * @data 28/09/2020
 */
public class PropertyReader {

	private static Properties prop = new Properties();
	private static InputStream input = null;
	private static String pathProperties = Paths.get("").toAbsolutePath().toString()
			+ "\\src\\test\\resources\\config\\config.properties";

	private static void carregarProperties() {
		try {
			input = new FileInputStream(pathProperties);
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		if (prop.size() <= 0)
			carregarProperties();
		if (!prop.containsKey(key)) {
			throw new RuntimeException("Não existe a chave [ " + key + " ] no arquivo properties: " + pathProperties);
		}
		return prop.getProperty(key);
	}

}
