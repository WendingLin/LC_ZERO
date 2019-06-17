class Solution {
  public String intToRoman(int num) {
    String res = "";

    while (num != 0) {
      if (num >= 900) {
        if (num < 1000) {
          res += "CM";
          num -= 900;
        } else {
          res += "M";
          num -= 1000;
        }
      } else if (num >= 400) {
        if (num < 500) {
          res += "CD";
          num -= 400;
        } else {
          res += "D";
          num -= 500;
        }
      } else if (num >= 90) {
        if (num < 100) {
          res += "XC";
          num -= 90;
        } else {
          res += "C";
          num -= 100;
        }
      } else if (num >= 40) {
        if (num < 50) {
          res += "XL";
          num -= 40;
        } else {
          res += "L";
          num -= 50;
        }
      } else if (num >= 9) {
        if (num < 10) {
          res += "IX";
          num -= 9;
        } else {
          res += "X";
          num -= 10;
        }
      } else if (num >= 4) {
        if (num < 5) {
          res += "IV";
          num -= 4;
        } else {
          res += "V";
          num -= 5;
        }
      } else {
        res += "I";
        num -= 1;
      }
    }

    return res;
  }
}
