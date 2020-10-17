package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.GetEditRecipeCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class GetEditRecipeCommandParser implements Parser<GetEditRecipeCommand> {

    public GetEditRecipeCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new GetEditRecipeCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    GetEditRecipeCommand.MESSAGE_USAGE));
        }
    }

}
