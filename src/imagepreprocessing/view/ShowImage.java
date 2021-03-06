/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagepreprocessing.view;

import imagepreprocessing.filter.ImageFilterChain;
import imagepreprocessing.filter.impl.FinalFilter;
import imagepreprocessing.filter.impl.MedianFilter;
import imagepreprocessing.filter.impl.OtsuBinarizeFilter;
import imagepreprocessing.helper.FilteredImage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import org.neuroph.core.NeuralNetwork;
//import org.neuroph.imgrec.ColorMode;
//import org.neuroph.imgrec.FractionRgbData;
//import org.neuroph.imgrec.ImageRecognitionHelper;
//import org.neuroph.imgrec.ImageRecognitionPlugin;
//import org.neuroph.imgrec.ImageSizeMismatchException;
//import org.neuroph.imgrec.image.Dimension;
//import org.neuroph.util.TransferFunctionType;
import pca.PCATest;

/**
 * GUI for image preprocessing
 *
 * @author Sanja
 */
public class ShowImage extends javax.swing.JFrame {

    private BufferedImage image;
    List<FilteredImage> filteredImages;

    /**
     * Creates new form ShowImage
     */
    public ShowImage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageFileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        imageTextField = new javax.swing.JTextField();
        openImageButton = new javax.swing.JButton();
        processButton = new javax.swing.JButton();
        originalImageLabel = new javax.swing.JLabel();
        testNN = new javax.swing.JButton();
        trainNN = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        trainingLabel = new javax.swing.JLabel();
        imagePreprocessingPanel2 = new imagepreprocessing.view.ImagePreprocessingPanel();
        saveBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        imagePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(2, 1));

        imageTextField.setText(" ");

        openImageButton.setText("Choose image");
        openImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openImageButtonActionPerformed(evt);
            }
        });

        processButton.setText("Process");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        testNN.setText("Test Neural Network");
        testNN.setEnabled(false);
        testNN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testNNActionPerformed(evt);
            }
        });

        trainNN.setText("Train Neural Network");
        trainNN.setEnabled(false);
        trainNN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainNNActionPerformed(evt);
            }
        });

        saveBtn.setText("Save Final Image");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel1.setText("Image preprocessing");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(imageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(openImageButton)
                                .addGap(18, 18, 18)
                                .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(originalImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(imagePreprocessingPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(trainNN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(testNN, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(42, 42, 42))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(trainingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(302, 302, 302)
                                .addComponent(saveBtn)
                                .addGap(323, 323, 323))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addComponent(trainNN)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(testNN)
                            .addGap(134, 134, 134)
                            .addComponent(trainingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(openImageButton)
                                .addComponent(imageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(processButton))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(originalImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imagePreprocessingPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveBtn)))
                .addGap(36, 36, 36)
                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1);

        imagePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Images"));
        getContentPane().add(imagePanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trainNNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainNNActionPerformed
        JFileChooser dirChooser = new JFileChooser();
        dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        File dir = null;                                                            //Add functionality that user can see files, but not select them
        int returnVal = dirChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            dir = dirChooser.getSelectedFile();
            String dirName = dir.getName();                                           //Folder name(just the last part).
            NeuralNetworkTraining.trainNeuralNetwork(dirName);
            trainingLabel.setText("Training successful! Data set created from folder: " + dir.getName());
        }
    }//GEN-LAST:event_trainNNActionPerformed

    private void testNNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testNNActionPerformed
        int returnVal = imageFileChooser.showOpenDialog(this);
        File file = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = imageFileChooser.getSelectedFile();
            imageTextField.setText(file.getName());
            String result = NeuralNetworkTraining.testNeuralNetwork(file);
            resultLabel.setText(result);
        }
    }//GEN-LAST:event_testNNActionPerformed

    /**
     * Process images with chosen filters and show every step. If only final
     * image needs to be shown use processImage instead of processImageTest
     *
     * @param evt
     */
    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed

        //remove all previous images from panel
        imagePanel.removeAll();

        ImageFilterChain chain;
        chain = imagePreprocessingPanel2.getImageFilterChain();
        filteredImages = chain.processImageTest(image);

        for (FilteredImage filteretImage : filteredImages) {
            imagePanel.add(new ImagePanel(filteretImage.getImage(),
                    filteretImage.getFilterName()));
            new ImageFrame(filteretImage.getImage(), filteretImage.getFilterName());
        }
//        new ImageFrame(FinalFilter.getInstance().getSmallerOriginal(),"Final");
        //refresh form
        this.pack();
        this.repaint();
    }//GEN-LAST:event_processButtonActionPerformed
    private void openImageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //open file chooser
        int returnVal = imageFileChooser.showOpenDialog(this);
        File file = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = imageFileChooser.getSelectedFile();
            imageTextField.setText(file.getName());

            try {
                //read image from specified file
                image = ImageIO.read(file);
                //show original image
                originalImageLabel.setIcon(new ImageIcon(image));

            } catch (IOException e) {

                e.printStackTrace();
            }
        }

    }
//GEN-FIRST:event_openImageButtonActionPerformed

//GEN-LAST:event_openImageButtonActionPerformed
    /**
     * Save image that is currently processed in UI.
     *
     * @param fileName name of a file in which we save data.
     */
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed

        try {
            String outputFileName = imageTextField.getText()
                    .substring(0,imageTextField.getText()
                            .indexOf('.'))+"_filtered.jpg";
            File outputfile = new File(outputFileName);
            ImageIO.write(filteredImages.get(filteredImages.size()-1).getImage()
                    , "jpg", outputfile);
            JOptionPane.showMessageDialog(this, "Image saved. \n" + outputfile.getAbsolutePath() );
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_saveBtnActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowImage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser imageFileChooser;
    private javax.swing.JPanel imagePanel;
    private imagepreprocessing.view.ImagePreprocessingPanel imagePreprocessingPanel2;
    private javax.swing.JTextField imageTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton openImageButton;
    private javax.swing.JLabel originalImageLabel;
    private javax.swing.JButton processButton;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton testNN;
    private javax.swing.JButton trainNN;
    private javax.swing.JLabel trainingLabel;
    // End of variables declaration//GEN-END:variables

}
