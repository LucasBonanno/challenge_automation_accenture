package br.com.accenture.challenge.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

import br.com.accenture.challenge.utils.Utils;

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

	private static String pathProperties = Paths.get("").toAbsolutePath().toString();
	
	private static String getEndPath() {
		final String pathForWindows = "\\src\\test\\resources\\config\\config.properties";
		final String pathForUnix = "/src/test/resources/config/config.properties";
		return Utils.isUnix() ? pathForUnix : pathForWindows;
	}

	private static void carregarProperties() {
		final String fullPath = pathProperties + getEndPath();
		try {
			input = new FileInputStream(fullPath);
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
