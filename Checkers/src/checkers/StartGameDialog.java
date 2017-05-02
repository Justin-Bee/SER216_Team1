package checkers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import checkers.Checkers;


/**
 * Start game options
 */
public class StartGameDialog extends JDialog implements ActionListener{
		
	/**
	 * Constructor
	 */
	public StartGameDialog(){}
    /**
     * Control variables
     */
    private final JPanel contentPanel = new JPanel();
    ButtonGroup players = new ButtonGroup();
    JRadioButton p1 = new JRadioButton("1-Player", true);
    JRadioButton p2 = new JRadioButton("2-Player", false);
    JLabel mode=new JLabel("Mode");
    JLabel diff=new JLabel("Difficulty Level");
    JComboBox<String> level=new JComboBox<String>();
    int playerMode;
    int levelDiff;

    /**
     * Checkers object
     */
    private Checkers checkers = null;
    /**
     * Checker Panel
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
        
        //sets Mode Label preferences
        JLabel mode=new JLabel("Mode");
        GridBagConstraints gbc_modeLabel = new GridBagConstraints();
        gbc_modeLabel.anchor = GridBagConstraints.WEST;
        gbc_modeLabel.insets = new Insets(0, 0, 5, 5);
        gbc_modeLabel.gridx = 0;
        gbc_modeLabel.gridy = 0;
        contentPanel.add(mode, gbc_modeLabel);
        
        //sets Player Radio preferences
        ButtonGroup players = new ButtonGroup();
        JRadioButton p1 = new JRadioButton("1-Player", true);
        JRadioButton p2 = new JRadioButton("2-Player", false);
        p1.setPreferredSize(new Dimension(70, 24));
        p2.setPreferredSize(new Dimension(70, 24));
        players.add(p1);
        players.add(p2);
        contentPanel.add(p1);
        contentPanel.add(p2);
        //listener for 1 player
        p1.addActionListener((ActionListener) this);
        //listener for 2 players
        p2.addActionListener((ActionListener) this);

        //sets Difficulty Label preferences
        JLabel diff=new JLabel("Difficulty Level");
        GridBagConstraints gbc_diffLabel = new GridBagConstraints();
        gbc_diffLabel.anchor = GridBagConstraints.SOUTHWEST;
        gbc_diffLabel.insets = new Insets(0, 0, 5, 5);
        gbc_diffLabel.gridx = 0;
        gbc_diffLabel.gridy = 1;
        contentPanel.add(diff, gbc_diffLabel);
        
        //creates difficulty combo box
        JComboBox<String> level = new JComboBox<String>();
        level.setModel(new DefaultComboBoxModel<String>(new String[] {"Easy", "Fairly Easy", "Moderate", "Bit Difficult", "Tough"}));
        //gets value
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
        
        //creates button to close dialog
        JButton startButton = new JButton("START GAME");
        GridBagConstraints gbc_startButton = new GridBagConstraints();
        gbc_startButton.anchor = GridBagConstraints.SOUTH;
        gbc_startButton.insets = new Insets(0, 0, 5, 5);
        gbc_startButton.gridx = 3;
        gbc_startButton.gridy = 5;
        contentPanel.add(startButton, gbc_startButton);
        startButton.setActionCommand("START GAME");
        //close dialog
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	setVisible(false);
        		dispose();
            }
        });
        
        //creates button to accept option changes
        JButton acceptButton = new JButton("ACCEPT");
        GridBagConstraints gbc_acceptButton = new GridBagConstraints();
        gbc_acceptButton.anchor = GridBagConstraints.SOUTH;
        gbc_acceptButton.insets = new Insets(0, 0, 5, 5);
        gbc_acceptButton.gridx = 2;
        gbc_acceptButton.gridy = 5;
        contentPanel.add(acceptButton, gbc_acceptButton);
        acceptButton.setActionCommand("ACCEPT");
        //adds listener
        acceptButton.addActionListener((ActionListener) this);
}
    /*
     * Returns selected number of players    
     * @return playerMode number of players
     */
    public int getSelectedMode(){
    	playerMode=p1.isSelected()?1:2;
    	return playerMode;
    }
    
    /*
     * Returns selected difficulty level
     * @return levelDiff difficulty level
     */
    public int getLevelIndex(){
    	levelDiff = level.getSelectedIndex();
    	return levelDiff;
    }
    
    /*
     * Handles actions from player selections and accept button (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
	@Override
	public void actionPerformed(ActionEvent arg0) {
    	if(arg0.getActionCommand().equalsIgnoreCase("1-Player")){
    		checkers.update1Player();
    	}
    	if(arg0.getActionCommand().equalsIgnoreCase("2-Player")){
    		checkers.update2Player();
    	}
    	if(arg0.getActionCommand().equalsIgnoreCase("ACCEPT")){
            checkers.selectedMode = getSelectedMode();
            checkers.difficulty = getLevelIndex();
            checkers.newGame();

    	}
		
	}
        
};
