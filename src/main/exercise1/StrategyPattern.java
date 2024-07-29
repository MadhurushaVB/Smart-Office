interface TextFormatter {
    String format(String text);
}

class PlainTextFormatter implements TextFormatter {
    public String format(String text) {
        return text;
    }
}

class HTMLFormatter implements TextFormatter {
    public String format(String text) {
        return "<html><body>" + text + "</body></html>";
    }
}

class MarkdownFormatter implements TextFormatter {
    public String format(String text) {
        return "**" + text + "**";
    }
}

class TextEditor {
    private TextFormatter formatter;

    public TextEditor(TextFormatter formatter) {
        this.formatter = formatter;
    }

    public void setFormatter(TextFormatter formatter) {
        this.formatter = formatter;
    }

    public void publishText(String text) {
        System.out.println(formatter.format(text));
    }
}

public class StrategyPattern{
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(new PlainTextFormatter());
        editor.publishText("Text Editor");

        editor.setFormatter(new HTMLFormatter());
        editor.publishText("HTML Formatter");

        editor.setFormatter(new MarkdownFormatter());
        editor.publishText("Markdown Formatter");
    }
}