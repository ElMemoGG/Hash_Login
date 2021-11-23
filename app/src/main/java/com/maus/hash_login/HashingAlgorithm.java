package com.maus.hash_login;
import java.util.Objects;
public class HashingAlgorithm {

    static String[]  table = new String[]{
            "A"
            , "B"
            , "C"
            , "D"
            , "E"
            , "F"
            , "G"
            , "H"
            , "I"
            , "J"
            , "K"
            , "L"
            , "M"
            , "N"
            , "O"
            , "P"
            , "Q"
            , "R"
            , "S"
            , "T"
            , "U"
            , "V"
            , "W"
            , "X"
            , "Y"
            , "Z"
            , "a"
            , "b"
            , "c"
            , "d"
            , "e"
            , "f"
            , "g"
            , "h"
            , "i"
            , "j"
            , "k"
            , "l"
            , "m"
            , "n"
            , "o"
            , "p"
            , "q"
            , "r"
            , "s"
            , "t"
            , "u"
            , "v"
            , "w"
            , "x"
            , "y"
            , "z"
            , "0"
            , "1"
            , "2"
            , "3"
            , "4"
            , "5"
            , "6"
            , "7"
            , "8"
            , "9"
            , "!"
            , "\""
            , "#"
            , "$"
            , "%"
            , "&"
            , "'"
            , "("
            , ")"
            , "*"
            , "+"
            , ","
            , "-"
            , "."
            , "/"
            , ":"
            , ";"
            , "<"
            , "="
            , ">"
            , "?"
            , "@"
            , "["
            , String.valueOf((char) 92)
            , "]"
            , "^"
            , "_"
            , "`"
            , "¿"
            , "¡"

    };

    static String[] table2 = new String[]{

            "_Qw"
            , "UvS"
            , "gK&"
            , "+6]"
            , "IX-"
            , "Ded"
            , "$u-"
            , "+=A"
            , "unN"
            , "[ga"
            , "k/t"
            , "jcF"
            , "d)Z"
            , "]¿Y"
            , ",<A"
            , "^'A"
            , "_y^"
            , "fIA"
            , "sxK"
            , "tAh"
            , "c7,"
            , "V]3"
            , "Ufs"
            , "q$R"
            , ")$6"
            , "-@D"
            , "Q`7"
            , "<c&"
            , "qT."
            , "p[*"
            , "iD$"
            , "Kri"
            , "*D;"
            , "]Yd"
            , "n*e"
            , "mn)"
            , "T;("
            , "#v9"
            , "$r¡"
            , "0_."
            , "'hT"
            , "k5;"
            , "+¿<"
            , "x%R"
            , "k;S"
            , "C6¡"
            , "¿(%"
            , "^'x"
            , ")t'"
            , "]Vr"
            , "e¡a"
            , "Y5b"
            , ";Jt"
            , "&Xz"
            , "P+U"
            , "Olw"
            , "ez@"
            , "iMf"
            , "3wI"
            , "¿n#"
            , "h$Z"
            , "uU'"
            , "V$d"
            , "*a2"
            , "gE="
            , "kx["
            , "9$e"
            , "![!"
            , "fbr"
            , "%v`"
            , "<9f"
            , "^M'"
            , "/F_"
            , ")[" + String.valueOf((char) 92)
            , "6R="
            , "C%u"
            , "Y2!"
            , "2¡A"
            , "$?T"
            , "Ne-"
            , ":M6"
            , "/25"
            , "pLA"
            , "j)z"
            , "cME"
            , "&I."
            , "+h:"
            , "UWa"
            , "`Ji"
            , "(B;"
            , "TrA"
            , "ZE7"

    };



    public static String hashing(String secret) {

        String cadenaAsci = "";
        String hexaDecimal = "";
        String bigHexaDecimal = "";
        int value;

        for (int i = 0; i < secret.length(); i++) {
            String pivot = String.valueOf(secret.charAt(i));
            String newPivot = "";


            for (int j = 0; j < table.length; j++) {

                if (Objects.equals(table[j], pivot)) {
                    if (j + 5 < table2.length) {
                        newPivot = table2[j + 5];
                    } else {
                        newPivot = table2[(j + 5) - table2.length];
                    }
                    break;
                }
            }
            for (int k = 0; k < newPivot.length(); k++) {
                value = newPivot.charAt(k);
                cadenaAsci = cadenaAsci + value;
            }
            hexaDecimal = Integer.toHexString(Integer.valueOf(cadenaAsci));
            bigHexaDecimal = bigHexaDecimal + hexaDecimal;
            cadenaAsci="";

        }
        return bigHexaDecimal;
    }
}
