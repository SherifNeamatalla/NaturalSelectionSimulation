package view.viewswing.sidebars;

import javax.swing.*;
import java.awt.*;

/**
 * Holds information regarding the generation, e.g: how many generations till now, how many per
 * current generation
 */
public class BottomBar extends JPanel {

  private static final String TOTAL_CREATURES_COUNT_TEXT = "Total creatures count";

  private static final String CURRENT_CREATURES_COUNT_TEXT = "Current creatures count";

  public BottomBar() {
    createGridLayout();
    addTitle();
    addTextAreas();
    setBackground(new Color(11, 75, 84));
    setVisible(true);
  }

  private void createGridLayout() {
    GridBagLayout gridBagLayout = new GridBagLayout();
    setLayout(gridBagLayout);
  }

  private JTextField initSingleTextArea() {
    JTextField textField = new JTextField();
    textField.setForeground(Color.BLACK);
    textField.setBackground(new Color(241, 228, 232));
    textField.setEditable(false);

    return textField;
  }

  private JLabel initSingleLabel(String text) {
    JLabel jLabel = new JLabel(text);
    jLabel.setForeground(Color.WHITE);
    return jLabel;
  }

  private void addLabeledTextArea(Integer gridY, Integer gridX, String text) {
    GridBagConstraints gbc = createGbc(gridX, gridY);
    add(initSingleLabel(text), gbc);
    gbc = createGbc(gridX + 1, gridY);
    add(initSingleTextArea(), gbc);
  }

  private GridBagConstraints createGbc(int x, int y) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;

    gbc.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
    gbc.fill = (x == 0) ? GridBagConstraints.BOTH : GridBagConstraints.HORIZONTAL;

    //    gbc.insets = (x == 0) ?  WEST : EAST;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    return gbc;
  }

  private void addTextAreas() {
    addLabeledTextArea(1, 0, TOTAL_CREATURES_COUNT_TEXT);
    addLabeledTextArea(1, 2, TOTAL_CREATURES_COUNT_TEXT);
    addLabeledTextArea(1, 4, TOTAL_CREATURES_COUNT_TEXT);
    addLabeledTextArea(2, 0, CURRENT_CREATURES_COUNT_TEXT);
  }

  private void addTitle() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.CENTER;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 5;
//    gbc.gridheight = 5;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.weightx = 1;
    gbc.weighty = 1;

    JLabel title = new JLabel("Simulation Statistics");
    title.setHorizontalAlignment(SwingConstants.CENTER);
    title.setForeground(Color.WHITE);
    add(title, gbc);
  }

  public void updateView() {}
}
