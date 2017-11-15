package org.autogenral.brackets.validator.validators;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.autogenral.brackets.validator.BracketsValidatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dan.stoica
 *
 */
public class BracketsBalanceValidator extends AbstractBracketsValidator
{
	public BracketsBalanceValidator(AbstractBracketsValidator next)
	{
		super(next);
	}

	private static final String EMPTY_REPLACEMENT = "";

	private static final String CURLY_BRAKET = "\\{\\}";

	private static final String ROUND_BRACKET = "\\(\\)";

	private static final String SQUARE_BRACKET = "\\[\\]";

	private Logger logger = LoggerFactory.getLogger(BracketsValidatorService.class);

	private static final int[] BRACKETS =
	{
			'(', ')', '[', ']', '{', '}'
	};

	static
	{
		Arrays.sort(BRACKETS);
	}

	@Override
	protected void isValid(String input) throws UnbalancedBracketsException
	{
		String brackets = collectBracketsFromSource(input);

		while (containsValidBrackets(brackets))
		{
			brackets = removeValidBrackets(brackets);
		}

		if (hasBrackets(brackets))
		{
			throw new UnbalancedBracketsException(brackets, input);
		}

		logger.trace("Nice balanced string: $0", input);
	}

	/**
	 * @param input
	 * @return a string containing just the brackets; Any other characters are
	 *         removed.
	 */
	private String collectBracketsFromSource(String input)
	{
		List<String> in = input.chars().filter(c -> isBracket(c)).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toList());
		String brackets = in.size() > 0 ? in.stream().reduce((acc, e) -> acc + e).get() : "";
		return brackets;
	}

	private boolean hasBrackets(String value)
	{
		return value.length() > 0;
	}

	private String removeValidBrackets(String out)
	{
		out = out.replaceAll(SQUARE_BRACKET, EMPTY_REPLACEMENT).replaceAll(ROUND_BRACKET, EMPTY_REPLACEMENT).replaceAll(CURLY_BRAKET,
			EMPTY_REPLACEMENT);
		return out;
	}

	private static boolean isBracket(int c)
	{
		return Arrays.binarySearch(BRACKETS, c) >= 0;
	}

	private boolean containsValidBrackets(String input)
	{
		return hasBrackets(input) && (input.contains("[]") || input.contains("()") || input.contains("{}"));
	}

}
