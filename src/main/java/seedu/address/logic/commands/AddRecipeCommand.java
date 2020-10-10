package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CALORIES;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INGREDIENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INSTRUCTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RECIPE_IMAGE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.recipe.Recipe;

/**
 * Adds a recipe to the Wishful Shrinking.
 */
public class AddRecipeCommand extends Command {

    public static final String COMMAND_WORD = "addR";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a recipe to the Wishful Shrinking. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_INGREDIENT + "INGREDIENT "
            + PREFIX_CALORIES + "CALORIES "
            + PREFIX_INSTRUCTION + "INSTRUCTIONS "
            + PREFIX_RECIPE_IMAGE + "IMAGE "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "Chicken salad "
            + PREFIX_INGREDIENT + "chicken, lettuce, tomato "
            + PREFIX_CALORIES + "100 "
            + PREFIX_INSTRUCTION + "1. cook 2. eat "
            + PREFIX_RECIPE_IMAGE + "images/salad.jpg "
            + PREFIX_TAG + "healthy "
            + PREFIX_TAG + "delicious";



    public static final String MESSAGE_SUCCESS = "New recipe added: %1$s";
    public static final String MESSAGE_DUPLICATE_RECIPE = "This recipe already exists in the Wishful Shrinking";

    private final Recipe toAdd;

    /**
     * Creates an AddRecipeCommand to add the specified {@code Recipe}
     */
    public AddRecipeCommand(Recipe recipe) {
        requireNonNull(recipe);
        toAdd = recipe;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasRecipe(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_RECIPE);
        }

        model.addRecipe(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddRecipeCommand // instanceof handles nulls
                && toAdd.equals(((AddRecipeCommand) other).toAdd));
    }
}
