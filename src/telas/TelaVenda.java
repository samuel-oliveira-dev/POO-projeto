/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package telas;

import escritaLeitura.EscritaLeituraCliente;
import regraNegocio.Livro;
import escritaLeitura.EscritaLeituraLivro;
import escritaLeitura.EscritaLeituraVenda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import regraNegocio.Cliente;
import regraNegocio.Venda;

/**
 *
 * @author samuk
 */
public class TelaVenda extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaVenda
     */
    public TelaVenda() {
        initComponents();
    }
    
    float subtotal = 0;
    
    public void consultar2(){
        String nome = txtBusca.getText();
        int quantidade = Integer.parseInt(jsQuantidade.getValue().toString());
        EscritaLeituraLivro ell = new EscritaLeituraLivro();
        ArrayList<Livro> populacao = ell.buscar(ComboCategoria.getSelectedItem().toString(),nome);
        DefaultTableModel dtm =  (DefaultTableModel) tbVendas.getModel();
        
        if (nome == null || nome.isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha o campo para realizar a busca!", "Campo em branco", JOptionPane.ERROR_MESSAGE);
            txtBusca.setText("");
        } else{
            if (quantidade <= 0){
                JOptionPane.showMessageDialog(this, "Informe a quantidade de produtos desejados!", "Quantidade nula", JOptionPane.ERROR_MESSAGE);
            } else{
                for(Livro l : populacao){
                    dtm.addRow(
                            new Object[]{
                                l.getTitulo(),
                                l.getAutor(),
                                l.getCodigo(),
                                l.getPreco() * quantidade,
                                quantidade,
                            }
                    );
                }
                subtotal += populacao.get(0).getPreco() * quantidade;
                jTextPane1.setText("Subtotal: "+ subtotal);
                txtBusca.setText("");
                jsQuantidade.setValue(1);
            }
        }
    }
    
    public void setJTextCodigo(String cod){
        txtBusca.setText(cod);
    }
    
    public void setTextPane(String str){
        
        jTextPane1.setText(str);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jsQuantidade = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        txtBusca = new javax.swing.JFormattedTextField();
        ComboCategoria = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbVendas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jLabel2.setText("Quantidade:");

        jsQuantidade.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel3.setText("CPF:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/selling.png"))); // NOI18N
        jButton1.setText("Concluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/checked.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextPane1.setEditable(false);
        jScrollPane2.setViewportView(jTextPane1);

        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCPF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextFieldCPFMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jFormattedTextFieldCPFMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jFormattedTextFieldCPFMousePressed(evt);
            }
        });
        jFormattedTextFieldCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldCPFActionPerformed(evt);
            }
        });

        ComboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Autor", "Codigo" }));

        tbVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Titulo", "Autor", "Codigo", "Preco", "Quantidade"
            }
        ));
        jScrollPane3.setViewportView(tbVendas);

        jLabel1.setText("Pagamento:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "cartao", "Pix", "Cheque" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jsQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(104, 104, 104)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jsQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EscritaLeituraCliente elc = new EscritaLeituraCliente();
        EscritaLeituraLivro ell = new EscritaLeituraLivro();
        EscritaLeituraVenda elv = new EscritaLeituraVenda();
        
        ArrayList<Cliente> clientes = elc.buscar("CPF", jFormattedTextFieldCPF.getText());
        
        String cpf = elc.undoMaskCpf(jFormattedTextFieldCPF.getText()).isBlank()? null: jFormattedTextFieldCPF.getText() ;
        String cod =  txtBusca.getText();
        //ArrayList<Cliente> clientes =  elc.buscar("CPF", cpf);
        int qtd = Integer.parseInt(jsQuantidade.getValue().toString());
        
        if(clientes.size() == 0){
            String[] opcoes = {"Sim", "Nao"};
            int cadastrarNovoCliente = JOptionPane.showOptionDialog(this, "Cliente sem Cadastro. Deseja Cadastra-lo?", "Cadastro Inexistente", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, frameIcon, opcoes, "Sim");
            if (cadastrarNovoCliente == 0){
                TelaCadastroCliente obj = new TelaCadastroCliente();
                JDesktopPane desk = getDesktopPane();
                desk.add(obj);
                obj.setVisible(true);
                  } else {
                if(qtd > 0){

                    Venda venda = new Venda(cod, cpf,qtd);
                    elv.salvar(venda, elv.PATH);
                    
                    elv.vender(cod, qtd);
                } else {
                    JOptionPane.showMessageDialog(this, "Escolha uma quantidade maior que 0 para continuar.");
                }
            } 
        
         
        }
        
        
        //Livro l = new Livro();
        //l.vender(jFormattedTextFieldCodigo.getText(), Integer.parseInt(jSpinnerQuantidade.getValue().toString()));
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        consultar2();
        txtBusca.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jFormattedTextFieldCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldCPFActionPerformed

    private void jFormattedTextFieldCPFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCPFMouseExited
        // TODO add your handling code here:
        
        
        
        
        
        
    }//GEN-LAST:event_jFormattedTextFieldCPFMouseExited

    private void jFormattedTextFieldCPFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCPFMousePressed
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_jFormattedTextFieldCPFMousePressed

    private void jFormattedTextFieldCPFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCPFMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jFormattedTextFieldCPFMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JSpinner jsQuantidade;
    private javax.swing.JTable tbVendas;
    private javax.swing.JFormattedTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
