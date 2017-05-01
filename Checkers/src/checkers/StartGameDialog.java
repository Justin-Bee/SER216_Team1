package checkers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



/**
 * Start game options
 */
public class StartGameDialog extends JDialog{
		
	public StartGameDialog(){
		
	}
    /**
     * Control variables
     */
    private final JPanel contentPanel = new JPanel();
    ButtonGroup players = new ButtonGroup();
    JRadioButton p1 = new JRadioButton("1-Player", true);
    JRadioButton p2 = new JRadioButton("2-Player", false);
    JLabel mode=new JLabel("Mode");
    JLabel diff=new JLabel("Difficulty Level");
    JComboBox level=new JComboBox();
    int playerMode;
    int levelDiff;

    /**
     * Checkers object
     */
    private Checkers checkers = null;
    /**
     * Defect Log Panel
     */
    Checkers checkersPanel;

    /**
     * Create the dialog.
     */
    public StartGameDialog(Checkers _checkersPanel) {
        // Set the checkers panel
        checkersPanel = _checkersPanel;
        // Init form
        jbInit();

    }

    /**
     * Initiates the panel with all widgets, buttons, and more
     */
    void jbInit() {
        setBounds(100, 100, 460, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.WEST);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[] { 27, 70, 30, 69, 86 };
        gbl_contentPanel.rowHeights = new int[] { 24, 0, 0, 0, 60, 0 };
        gbl_contentPanel.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0 };
        gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
        contentPanel.setLayout(gbl_contentPanel);
        JLabel mode=new JLabel("Mode");
        GridBagConstraints gbc_modeLabel = new GridBagConstraints();
        gbc_modeLabel.anchor = GridBagConstraints.WEST;
        gbc_modeLabel.insets = new Insets(0, 0, 5, 5);
        gbc_modeLabel.gridx = 0;
        gbc_modeLabel.gridy = 0;
        contentPanel.add(mode, gbc_modeLabel);
        ButtonGroup players = new ButtonGroup();
        JRadioButton p1 = new JRadioButton("1-Player", true);
        JRadioButton p2 = new JRadioButton("2-Player", false);
        p1.setPreferredSize(new Dimension(70, 24));
        p2.setPreferredSize(new Dimension(70, 24));
        players.add(p1);
        players.add(p2);
        contentPanel.add(p1);
        contentPanel.add(p2);
        p1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
        		checkers.update1Player();
            }
        });
        p2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
        		checkers.update2Player();
            }
        });
        
        JLabel diff=new JLabel("Difficulty Level");
        GridBagConstraints gbc_diffLabel = new GridBagConstraints();
        gbc_diffLabel.anchor = GridBagConstraints.SOUTHWEST;
        gbc_diffLabel.insets = new Insets(0, 0, 5, 5);
        gbc_diffLabel.gridx = 0;
        gbc_diffLabel.gridy = 1;
        contentPanel.add(diff, gbc_diffLabel);
        level = new JComboBox();
        level.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Fairly Easy", "Moderate", "Bit Difficult", "Tough"}));
        level.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				getLevelIndex();
				
			}
        	
        });
        GridBagConstraints gbc_levelCombo = new GridBagConstraints();
        gbc_levelCombo.anchor = GridBagConstraints.SOUTHWEST;
        gbc_levelCombo.gridx = 1;
        gbc_levelCombo.gridy = 1;
        contentPanel.add(level, gbc_levelCombo);
        
        JButton okButton = new JButton("OK");
        GridBagConstraints gbc_okButton = new GridBagConstraints();
        gbc_diffLabel.anchor = GridBagConstraints.SOUTH;
        gbc_diffLabel.insets = new Insets(0, 0, 5, 5);
        gbc_diffLabel.gridx = 3;
        gbc_diffLabel.gridy = 5;
        contentPanel.add(okButton, gbc_okButton);
        okButton.setActionCommand("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
        		checkers.updateStartButton();
        		handleCloseButton();
            }
        });

    }
        
    public int getSelectedMode(){
    	playerMode=p1.isSelected()?1:2;
    	return playerMode;
    }
    
    public int getLevelIndex(){
    	levelDiff = level.getSelectedIndex();
    	return levelDiff;
    }
    
    
    private void handleCloseButton() {
        // Now close the form
        this.setVisible(false);
        this.dispose();
    }
        
};
