package com.epam.rd.autotasks.task01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceCamelCase.class)
class Task01Test {

	@Test
	void evenElementsAreSwapped() {
		{
			int[] expected = null;
			int[] actual = null;
			Task01.swapEven(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[] expected = new int[] {};
			int[] actual = new int[] {};
			Task01.swapEven(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[] expected = new int[] { 1 };
			int[] actual = new int[] { 1 };
			Task01.swapEven(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[] expected = new int[] { 1, 2 };
			int[] actual = new int[] { 1, 2 };
			Task01.swapEven(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[] expected = new int[] { 1, 2, 3 };
			int[] actual = new int[] { 1, 2, 3 };
			Task01.swapEven(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[] expected = new int[] { 0, 2, 3 };
			int[] actual = new int[] { 0, 2, 3 };
			Task01.swapEven(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[] expected = new int[] { 1, 2, 0 };
			int[] actual = new int[] { 1, 2, 0 };
			Task01.swapEven(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[] expected = new int[] { 4, 2, 0 };
			int[] actual = new int[] { 0, 2, 4 };
			Task01.swapEven(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[] expected = new int[] { 4, 2, 3, 0 };
			int[] actual = new int[] { 0, 2, 3, 4 };
			Task01.swapEven(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[] expected = new int[] { 4, 5, 0, 3, 10 };
			int[] actual = new int[] { 10, 5, 0, 3, 4 };
			Task01.swapEven(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[] expected = new int[] { 100, 4, 3, 2, 5 };
			int[] actual = new int[] { 100, 2, 3, 4, 5 };
			Task01.swapEven(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[] expected = new int[] { 54, 4, 3, 45, 33, 8, 2, 100 };
			int[] actual = new int[] { 100, 2, 3, 45, 33, 8, 4, 54 };
			Task01.swapEven(actual);
			assertArrayEquals(expected, actual);
		}
	}
}

class ReplaceCamelCase extends DisplayNameGenerator.Standard {
	@Override
	public String generateDisplayNameForClass(Class<?> testClass) {
		return replaceCamelCase(super.generateDisplayNameForClass(testClass));
	}

	@Override
	public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
		return replaceCamelCase(super.generateDisplayNameForNestedClass(nestedClass));
	}

	@Override
	public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
		return this.replaceCamelCase(testMethod.getName());
	}

	String replaceCamelCase(String camelCase) {
		StringBuilder result = new StringBuilder();
		result.append(Character.toUpperCase(camelCase.charAt(0)));
		for (int i = 1, len = camelCase.length(); i < len; i++) {
			if (Character.isUpperCase(camelCase.charAt(i))) {
				result.append(' ');
				result.append(Character.toLowerCase(camelCase.charAt(i)));
			} else {
				result.append(camelCase.charAt(i));
			}
		}
		return result.toString();
	}
}
