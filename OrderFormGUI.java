import javax.swing.*;

public class OrderFormGUI {
    public static void main(String[] args) {
        /** DO NOT CHANGE VALUES BELOW **/
        boolean hoodieInStock = true;
        boolean tshirtInStock = false;
        boolean longsleeveInStock = true;
        String item = "";
        int quantity = 0;
        String name = "";
        /** DO NOT CHANGE VALUES ABOVE **/


        int reply;
        do {
            boolean temp = true;
            do {
                //TODO: display error GUI if item selected is out of stock
                String[] options = {"Hoodie", "T-shirt", "Long sleeve"};
                item = (String) JOptionPane.showInputDialog(null, "Select item style ", "Order Form",
                        JOptionPane.PLAIN_MESSAGE, null, options, null);

                if (item.equals("Hoodie")) {
                    temp = hoodieInStock;

                } else if (item.equals("T-shirt")) {
                    temp = tshirtInStock;

                } else if (item.equals("Long sleeve")) {
                    temp = longsleeveInStock;

                }
                if (temp == false){
                    JOptionPane.showMessageDialog(null, "Out of Stock", "Order Form",
                        JOptionPane.ERROR_MESSAGE);
                }
            } while (!(temp));
            
            
            do {
                try {
                    quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter quantity", "Order Form",
                        JOptionPane.QUESTION_MESSAGE));
                    if ((quantity == 0) || (quantity < 0)) {
                        JOptionPane.showMessageDialog(null, "Enter a number greater than 0", "Order Form",
                            JOptionPane.ERROR_MESSAGE);
                    }
                        

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Enter an integer", "Order Form",
                    JOptionPane.ERROR_MESSAGE);
                

                }
                

            } while ((quantity == 0) || (quantity < 0));

    

            boolean temp3 = true;
            do {
                name = JOptionPane.showInputDialog(null, "Enter your Name", "Order Form",
                    JOptionPane.QUESTION_MESSAGE);

                try {
                    if (name == (String)(name)) {

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Enter first and last name", "Order Form",
                        JOptionPane.ERROR_MESSAGE);
                }

                int count = 0;
                for (int i = 0; i < name.length(); i++ ) {
                    if (name.charAt(i) == ' ') {
                        temp3 = false; 
                        count++;
                    }

                }
                if (count < 1) {
                    JOptionPane.showMessageDialog(null, "Enter first and last name", "Order Form",
                        JOptionPane.ERROR_MESSAGE);
                }

            } while (temp3);
            //TODO: display error GUI if input does not include a space


            /** Order Confirmation Message **/
            String resultMessage = "Name: " + name + "\nItem: " + item + "\nQuantity: " + quantity;
            JOptionPane.showMessageDialog(null, resultMessage, "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);

            //TODO: loop through order form again if YES
            reply = JOptionPane.showConfirmDialog(null, "Would you like to place another order?", "Order Form", JOptionPane.YES_NO_OPTION);


        } while (reply == JOptionPane.YES_OPTION); 
        

    }
}

