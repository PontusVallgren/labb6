public class hints {
    public String giveHint(String word, int hintNumber) {
        if(hintNumber == 1) {
            return "It might be a country";
        } if (hintNumber == 2 && word.equalsIgnoreCase("Sweden") || word.equalsIgnoreCase("Finland")) {
            return "There are usually snow at this place!";
        } if(hintNumber == 2 && word.equalsIgnoreCase("Spain") || word.equalsIgnoreCase("Thailand")) {
            return "Popular vacation destination for Swedes";
        }
        else {
            return null;
        }
    }
}
