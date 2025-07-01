package dev.ofekmalka.fileassertions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FileAssertionsTest {

	@Test
	void shouldExistAndBeReadable() {
		assertThat(TestFileResources.animalsListFile())//
		.exists()//
		.isRegularFile()//
		.isReadable()//
		.hasFileName("animals-list.txt")//
		.hasExtension("txt");//
	}

	@Test
	void shouldNotExist() {
		assertThat(TestFileResources.missingFile()).doesNotExist();
	}

	@Test
	void shouldHaveCorrectSize() {
		assertThat(TestFileResources.sizeOf(TestFileResources.programmingLangsFile())).isGreaterThan(10);
	}

	@Test
	void shouldHaveCorrectContent() {
		assertThat(TestFileResources.animalsListFile())//
		.content()//

		.containsIgnoringCase("dog")//
		.doesNotContainIgnoringCase("unicorn");//
	}

	@Test
	void shouldHaveDifferentSizes() {
		assertThat(TestFileResources.sizeOf(TestFileResources.animalsListFile()))
		.isNotEqualTo(TestFileResources.sizeOf(TestFileResources.animalsListFileV2()));

	}

	@Test
	void shouldHaveDifferentContent() {
		final var fileContent1 =

				TestFileResources.readString(TestFileResources.animalsListFile());
		final var fileContent2 = TestFileResources.readString(TestFileResources.animalsListFileV2());

		assertThat(fileContent1).isNotEqualTo(fileContent2);
	}

}
