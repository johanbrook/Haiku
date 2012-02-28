package edu.chl.wmax.haiku;

public class HaikuModel {

	/**
	 * Score max: 20 pt
	 */
	public static int haikuScore(String line1, String line2, String line3) {
		int score = 0;

		if (crit1(line1 + line2 + line3))
			score += 8;

		if (crit2(line1, line3))
			score += 4;

		if (crit3(line1, line2))
			score += 3;

		if (crit3(line3, line2))
			score += 3;

		if (crit5(line1 + line2 + line3))
			score += 1;
		if (crit6(line1, line2, line3))
			score += 1;

		return score;
	}

	/**
	 * Criteria 1: Has 17 vowels Score: 40%
	 */
	private static boolean crit1(String str) {
		return vowelCount(str) == 17;
	}

	/**
	 * Criteria 2: syllables(Line 1) == syllables(Line 3) Score 20%
	 */
	private static boolean crit2(String line1, String line3) {
		return vowelCount(line1) == vowelCount(line3);
	}

	/**
	 * Criteria 3: syllables(Line 1) - syllables(Line 2) between 0 and -2 Score
	 * 15% Criteria 4: syllables(Line 3) - syllables(Line 2) between 0 and -2
	 * Score 15%
	 */
	private static boolean crit3(String line1, String line2) {
		int count = vowelCount(line1) - vowelCount(line2);
		return (count <= 0 && count >= -2);
	}

	/**
	 * Criteria 5: Emphatic total punctuation between 1 and 3 Score 5%
	 */
	private static boolean crit5(String str) {
		int count = punctCount(str);

		return (count <= 3 && count >= 1);
	}

	/**
	 * Criteria 6: punctuation per row is max 1
	 */
	private static boolean crit6(String line1, String line2, String line3) {

		return punctCount(line1) <= 1 && punctCount(line2) <= 1
				&& punctCount(line3) <= 1;
	}

	private static int punctCount(String str) {
		String special = ".-!?";
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (special.contains(str.substring(i, i + 1))) {
				count++;
			}
		}
		return count;
	}

	private static int vowelCount(String str) {
		int count = 0;
		String vowels = "AEÉÈIOUYÅÄÖÜaeéèiouyåäü";

		for (int i = 0; i < str.length(); i++) {
			if (vowels.contains(str.substring(i, i + 1))) {
				count++;
			}
		}
		return count;
	}
}
