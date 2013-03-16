package com.timepath.hl2.io.test;

import com.timepath.hl2.io.VCCD;
import com.timepath.hl2.io.VCCD.Entry;
import com.timepath.steam.SteamUtils;
import com.timepath.steam.io.GCF;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author timepath
 */
@SuppressWarnings("serial")
public class VCCDTest extends javax.swing.JFrame {

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hashPanel = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        contentPane = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Caption Reader");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        hashPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("CRC32"));
        hashPanel.setMaximumSize(new java.awt.Dimension(2147483647, 83));
        hashPanel.setLayout(new java.awt.BorderLayout());
        hashPanel.add(jTextField3, java.awt.BorderLayout.PAGE_START);

        jTextField4.setEditable(false);
        jTextField4.setText("0");
        hashPanel.add(jTextField4, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(hashPanel);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CRC32", "Key", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setRowHeight(24);
        contentPane.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setMinWidth(85);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(85);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(160);
        jTable1.getColumnModel().getColumn(1).setCellEditor(getKeyEditor());
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(160);

        getContentPane().add(contentPane);

        jMenu1.setText("File");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("New");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNew(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadCaptions(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Import");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importCaptions(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCaptions(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        menuBar.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_INSERT, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Insert row");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertRow(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Delete row");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRow(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadCaptions(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadCaptions
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Open");
        
        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return (file.getName().startsWith("closecaption_") && (file.getName().endsWith(".dat"))) || file.isDirectory();
            }

            public String getDescription() {
                return "VCCD Files (.dat)";
            }
        };
        fc.setFileFilter(filter);

        int returnVal = fc.showOpenDialog(this);

        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            ArrayList<Entry> entries = cl.loadFile(file.getAbsolutePath().toString());
            LOG.log(Level.INFO, "Entries: {0}", entries.size());

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            for(int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            for(int i = 0; i < entries.size(); i++) {
                model.addRow(new Object[]{hexFormat(entries.get(i).getKey()), attemptDecode(entries.get(i).getKey()), entries.get(i).getValue()});
            }
        }
    }//GEN-LAST:event_loadCaptions

    private void saveCaptions(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCaptions
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Save");

        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return (file.getName().startsWith("closecaption_") && (file.getName().endsWith(".dat"))) || file.isDirectory();
            }

            public String getDescription() {
                return "VCCD Files (.dat)";
            }
        };
        fc.setFileFilter(filter);

        int returnVal = fc.showSaveDialog(this);

        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            ArrayList<Entry> entries = new ArrayList<Entry>();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            for(int i = 0; i < model.getRowCount(); i++) {
                Entry e = cl.getNewEntry();
                Object crc = model.getValueAt(i, 0);
                if(model.getValueAt(i, 1) != null && !model.getValueAt(i, 1).toString().isEmpty()) {
                    crc = hexFormat(VCCD.takeCRC32(model.getValueAt(i, 1).toString()));
                }
                e.setKey(Long.parseLong(crc.toString().toLowerCase(), 16));
                e.setValue(model.getValueAt(i, 2).toString());
                entries.add(e);
            }
            cl.saveFile(file.getAbsolutePath().toString(), entries);
        }
    }//GEN-LAST:event_saveCaptions

    private void importCaptions(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importCaptions
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Import");

        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return (file.getName().startsWith("closecaption_") && (file.getName().endsWith(".txt"))) || file.isDirectory();
            }

            public String getDescription() {
                return "VCCD Source Files (.txt)";
            }
        };
        fc.setFileFilter(filter);

        int returnVal = fc.showOpenDialog(this);

        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            ArrayList<Entry> entries = cl.importFile(file.getAbsolutePath().toString());
            LOG.log(Level.INFO, "Entries: {0}", entries.size());

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            for(int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            for(int i = 0; i < entries.size(); i++) {
                model.addRow(new Object[]{hexFormat(entries.get(i).getKey()), entries.get(i).getTrueKey(), entries.get(i).getValue()});
            }
        }
    }//GEN-LAST:event_importCaptions

    private void insertRow(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertRow
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{});
    }//GEN-LAST:event_insertRow

    private void deleteRow(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRow
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int newRow = Math.min(jTable1.getSelectedRow(), model.getRowCount() - 1);
        model.removeRow(jTable1.getSelectedRow());
        jTable1.setRowSelectionInterval(newRow, newRow);
    }//GEN-LAST:event_deleteRow

    private void createNew(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNew
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for(int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        model.addRow(new Object[]{});
    }//GEN-LAST:event_createNew

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane contentPane;
    private javax.swing.JPanel hashPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

    private VCCD cl;

    //<editor-fold defaultstate="collapsed" desc="Entry point">
    /**
     * Creates new form CaptionLoaderFrame
     */
    public VCCDTest() {
        initComponents();

        jTextField3.getDocument().addDocumentListener(new DocumentListener() {
            
            public void changedUpdate(DocumentEvent e) {
                updateCRC();
            }

            public void removeUpdate(DocumentEvent e) {
                updateCRC();
            }

            public void insertUpdate(DocumentEvent e) {
                updateCRC();
            }

            public void updateCRC() {
                jTextField4.setText(hexFormat(VCCD.takeCRC32(jTextField3.getText())));
            }
        });

        cl = new VCCD();
    }

    private TableCellEditor getKeyEditor() {
        JComboBox comboBox = new JComboBox();
        comboBox.setEditable(true);
        hashmap = generateHash();
        Object[] vals = hashmap.values().toArray();
        Arrays.sort(vals);
        for(int i = 0; i < vals.length; i++) {
            comboBox.addItem(vals[i].toString());
        }
        DefaultCellEditor dce = new DefaultCellEditor(comboBox);
        ((JTextField)((JComboBox) dce.getComponent()).getEditor().getEditorComponent()).getDocument().addDocumentListener(new DocumentListener() {
            
            public void changedUpdate(DocumentEvent e) {
                updateCRC();
            }

            public void removeUpdate(DocumentEvent e) {
                updateCRC();
            }

            public void insertUpdate(DocumentEvent e) {
                updateCRC();
            }

            public void updateCRC() {
                jTextField4.setText(hexFormat(VCCD.takeCRC32(jTextField3.getText())));
            }
        });
        return dce;
    }

    private class EditorPaneRenderer extends JPanel implements TableCellRenderer {

        private int curX;

        private String text;

        EditorPaneRenderer() {
            super();
        }

        @Override
        public void paint(Graphics g) {
            g.setFont(this.getFont());
            FontMetrics fm = g.getFontMetrics();
            g.setColor(this.getBackground());
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(this.getForeground());

            for(int i = 0; i < text.length(); i++) {
                if(text.charAt(i) == '<') {
                }
            }

            drawWords(fm, g, text);
            curX = 0;
        }

        public void drawWords(FontMetrics fm, Graphics g, String str) {
            g.drawString(text, curX, fm.getHeight());
            curX += fm.stringWidth(str);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            if(isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(table.getBackground());
            }
            return this;
        }

        private void setText(String string) {
            this.text = string;
        }
    }

    private TableCellRenderer valueRenderer = new EditorPaneRenderer();

    private static final Logger LOG = Logger.getLogger(VCCDTest.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        final JFrame f = new JFrame("Loading caption reader...");
        JProgressBar pb = new JProgressBar();
        pb.setIndeterminate(true);
        f.add(pb);
        f.setMinimumSize(new Dimension(300, 50));
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        new Thread(new Runnable() {
            public void run() {
                final VCCDTest c = new VCCDTest();
                c.setLocationRelativeTo(null);
                c.setVisible(true);
                f.dispose();
            }
        }).start();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Hash codes">
    private HashMap<Integer, String> hashmap;

    private HashMap<Integer, String> generateHash() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        LOG.info("Generating hash codes ...");
        try {
            GCF gcf = new GCF(new File(SteamUtils.locateSteamAppsDirectory() + "/Team Fortress 2 Content.gcf"));

            CRC32 crc = new CRC32();

            String[] ls = new String(gcf.ls).split("\0");
//            String[] ls = gcf.getEntryNames();
            for(int i = 0; i < ls.length; i++) {
                int end = ls[i].length();
                int ext = ls[i].lastIndexOf('.');
                if(ext != -1) {
                    end = ext;
                }
                String sp = ls[i].substring(0, end);
                if(ls[i].toLowerCase().endsWith(".wav") || ls[i].toLowerCase().endsWith(".mp3")// ||
                    //                    ls[i].toLowerCase().endsWith(".vcd") || ls[i].toLowerCase().endsWith(".bsp") ||
                    //                    ls[i].toLowerCase().endsWith(".mp3") || ls[i].toLowerCase().endsWith(".bat") ||
                    //                    ls[i].toLowerCase().endsWith(".doc") || ls[i].toLowerCase().endsWith(".raw") ||
                    //                    ls[i].toLowerCase().endsWith(".pcf") || ls[i].toLowerCase().endsWith(".cfg") ||
                    //                    ls[i].toLowerCase().endsWith(".vbsp") || ls[i].toLowerCase().endsWith(".inf") ||
                    //                    ls[i].toLowerCase().endsWith(".rad") || ls[i].toLowerCase().endsWith(".vdf") ||
                    //                    ls[i].toLowerCase().endsWith(".ctx") || ls[i].toLowerCase().endsWith(".vdf") ||
                    //                    ls[i].toLowerCase().endsWith(".lst") || ls[i].toLowerCase().endsWith(".res") ||
                    //                    ls[i].toLowerCase().endsWith(".pop") || ls[i].toLowerCase().endsWith(".dll") ||
                    //                    ls[i].toLowerCase().endsWith(".dylib") || ls[i].toLowerCase().endsWith(".so") ||
                    //                    ls[i].toLowerCase().endsWith(".scr") || ls[i].toLowerCase().endsWith(".rc") ||
                    //                    ls[i].toLowerCase().endsWith(".vfe") || ls[i].toLowerCase().endsWith(".pre") ||
                    //                    ls[i].toLowerCase().endsWith(".cache") || ls[i].toLowerCase().endsWith(".nav") ||
                    //                    ls[i].toLowerCase().endsWith(".lmp") || ls[i].toLowerCase().endsWith(".bik") ||
                    //                    ls[i].toLowerCase().endsWith(".mov") || ls[i].toLowerCase().endsWith(".snd") ||
                    //                    ls[i].toLowerCase().endsWith(".midi") || ls[i].toLowerCase().endsWith(".png") ||
                    //                    ls[i].toLowerCase().endsWith(".ttf") || ls[i].toLowerCase().endsWith(".ico") ||
                    //                    ls[i].toLowerCase().endsWith(".dat") || ls[i].toLowerCase().endsWith(".pl") ||
                    //                    ls[i].toLowerCase().endsWith(".ain") || ls[i].toLowerCase().endsWith(".db") ||
                    //                    ls[i].toLowerCase().endsWith(".py") || ls[i].toLowerCase().endsWith(".xsc") ||
                    //                    ls[i].toLowerCase().endsWith(".bmp") || ls[i].toLowerCase().endsWith(".icns") ||
                    //                    ls[i].toLowerCase().endsWith(".txt") || ls[i].toLowerCase().endsWith(".manifest")
                    ) {
                    String str = sp;
                    if(str.split("_").length == 2) {
                        str = str.replaceAll("_", ".").replaceAll(" ", "");// + "\0";
                    }
//                    System.out.println(str);
                    crc.update(str.toLowerCase().getBytes());
                    map.put((int) crc.getValue(), str.toLowerCase()); // enforce lowercase for consistency
//                    logger.log(Level.INFO, "{0} > {1}", new Object[]{crc.getValue(), str});
                    crc.reset();
                } else {
//                    logger.info(ls[i]);
                }
            }
        } catch(IOException ex) {
            LOG.log(Level.WARNING, "Error generating hash codes", ex);
        }
        return map;
    }

    public static String hexFormat(int in) {
        return Integer.toHexString(in).toUpperCase();
    }

    private String attemptDecode(int hash) {
        if(!hashmap.containsKey(hash)) {
//            logger.log(Level.INFO, "hashmap does not contain {0}", hash);
            return null;
        }
        return hashmap.get(hash);
    }
    //</editor-fold>
}