package dev.ofekmalka.fileassertions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFileResources {

	public static Path animalsListFile() {
		return getPath("file/animals-list.txt");
	}

	public static Path animalsListFileV2() {
		return getPath("file/animals-list-v2.txt");
	}

	public static Path programmingLangsFile() {
		return getPath("file/programming-langs.txt");
	}

	public static Path missingFile() {
		return Paths.get("file/does-not-exist.txt");
	}

	public static long sizeOf(final Path path) {
		try {
			return Files.size(path);
		} catch (final IOException e) {
			throw new RuntimeException("Could not get file size: " + path, e);
		}
	}

	public static String readString(final Path path) {
		try {
			return Files.readString(path);
		} catch (final IOException e) {
			throw new RuntimeException("Could not get the content : " + path, e);
		}
	}


	private static Path getPath(final String resource) {
		try {
			final var normalized = resource.startsWith("/") ? resource : "/" + resource;
			final var url = TestFileResources.class.getResource(normalized);
			if (url == null)
				throw new IllegalArgumentException("Resource not found: " + resource);
			return Paths.get(url.toURI());
		} catch (final URISyntaxException e) {
			throw new RuntimeException("Failed to load resource: " + resource, e);
		}
	}

}
