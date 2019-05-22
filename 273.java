class Solution {

  public String numberToWords(int num) {
    if (num == 0)
      return "Zero";
    String v1[] = {"",        "One",     "Two",       "Three",    "Four",
                   "Five",    "Six",     "Seven",     "Eight",    "Nine",
                   "Ten",     "Eleven",  "Twelve",    "Thirteen", "Fourteen",
                   "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String v2[] = {"",      "",      "Twenty",  "Thirty", "Forty",
                   "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String v3[] = {"Thousand", "Million", "Billion"};
    String res = "";
    int count = 0;
    while (num != 0) {
      if (count % 3 == 0) { // 1+2
        int remain = num % 100;
        String text = "";
        if (remain > 19 && remain % 10 != 0) {
          text = v2[remain / 10] + " " + v1[remain % 10];
        } else if (remain > 19 && remain % 10 == 0) {
          text = v2[remain / 10];
        } else {
          text = v1[remain];
        }
        if (count == 0)
          res = text;
        else if (text == "")
          res += text;
        else
          res = text + " " + res;
        num = num / 100;
      } else if (count % 3 == 1) {
        int remain = num % 10;
        if (num % 10 != 0) {

          if (res.equals("") == false)
            res = v1[remain] + " "
                  + "Hundred " + res;
          else
            res = v1[remain] + " "
                  + "Hundred";
        }
        num = num / 10;
      } else {
        if (num % 1000 != 0) {

          if (res.equals("") == false)
            res = v3[count / 3] + " " + res;
          else
            res = v3[count / 3];
        }
      }
      count++;
    }
    return res;
  }
}
