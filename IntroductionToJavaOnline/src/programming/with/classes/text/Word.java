package programming.with.classes.text;

public class Word implements CompositionOfText {

    @Override
    public String getComposition() {
        System.out.println("pls enter Word: ");
        return " " + scanner.next();

    }
}
