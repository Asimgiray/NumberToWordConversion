import javax.swing.JOptionPane;
public  class  NumbertoWordConversion  

{
    private static final String[] specialNames = {
        "",
        " bin",
        " milyon",
        " milyar",
        " trilyon",
        " katrilyon",
        " kentilyon"
    };

    private static final String[] tensNames = {
        "",
        " on",
        " yirmi",
        " otuz",
        " k�rk",
        " elli",
        " altm��",
        " yetmi�",
        " seksen",
        " doksan"
    };

    private static final String[] numNames = {
        "",
        " ",
        " iki",
        " ��",
        " d�rt",
        " be�",
        " alt�",
        " yedi",
        " sekiz",
        " dokuz",
        " on",
        " onbir",
        " oniki",
        " on��",
        " ond�rt",
        " onbe�",
        " onalt�",
        " onyedi",
        " onsekiz",
        " ondokuz"
    };

    private String convertLessThanOneThousand(int number) {
        String current;

        if (number % 100 < 20){
            current = numNames[number % 100];
            number /= 100;
        }
        else {
            current = numNames[number % 10];
            number /= 10;

            current = tensNames[number % 10] + current;
            number /= 10;
        }
        if (number == 0) return current;
        return numNames[number] + " y�z" + current;
    }

    public String convert(long number) {

        if (number == 0) { return "zero"; }

        String prefix = "";

        if (number < 0) {
            number = -number;
            prefix = "eksi";
        }

        String current = "";
        int place = 0;

        do {
            long n = number % 1000;
            if (n != 0){
                String s = convertLessThanOneThousand((int)n);
                current = s + specialNames[place] + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        return (prefix + current).trim();
    }

    public static void main(String[] args) {
        NumbertoWordConversion obj = new NumbertoWordConversion();
        long sayi = Long.valueOf(JOptionPane.showInputDialog("L�tfen Bir Say� Girin"));
        JOptionPane.showMessageDialog(null, obj.convert(sayi),"Converted Version",JOptionPane.PLAIN_MESSAGE);
        System.out.println("*** " + obj.convert(sayi));
        System.out.println("*** " + obj.convert(-55));
    }
}