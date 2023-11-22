package detail;


import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import detail.repo.DeleteRepo;
import detail.repo.DetailRepo;
import list.ListFrame;
import modify.ModifyFrame;

public class DetailFrame extends JFrame {

	JButton b1 = new JButton("일람으로");
	JButton b2 = new JButton("수정");
	JButton b3 = new JButton("삭제");

	DetailRepo dr = new DetailRepo();



	public DetailFrame(String selectedBookTitle) {
		setTitle("도서관리시스템 - 상세화면");
		setSize(400, 300);

		setPanel(selectedBookTitle);

		setLocationRelativeTo(null);
		setVisible(true);
	}


	private void setPanel(String selectedBookTitle) {
		// TODO 自動生成されたメソッド・スタブ
		JPanel p = new JPanel(new GridLayout(0, 3));
		p.setSize(400, 500);
		JLabel l1 = new JLabel("책제목");
		JLabel l2 = new JLabel("카테고리");
		JLabel l3 = new JLabel("저자");
		JLabel l4 = new JLabel("출판사");
		JLabel l5 = new JLabel("책가격");
		JLabel l6 = new JLabel("대여상태");
		JLabel l7 = new JLabel("대여자");
		JLabel l8 = new JLabel("반납일");
		JLabel l9 = new JLabel("대여일");
		JLabel l10 = new JLabel("대여비");

		JLabel empty1 = new JLabel("");
		JLabel empty2 = new JLabel("");
		JLabel empty3 = new JLabel("");
		JLabel empty4 = new JLabel("");
		JLabel empty5 = new JLabel("");
		JLabel empty6 = new JLabel("");
		JLabel empty7 = new JLabel("");
		JLabel empty8 = new JLabel("");
		JLabel empty9 = new JLabel("");
		JLabel empty10 = new JLabel("");

		String[] bookInfo = dr.detail(selectedBookTitle);
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);
		JTextField t4 = new JTextField(10);
		JTextField t5 = new JTextField(10);
		String[] status = {"대여중", "대여가능", "분실"};
		JComboBox<String> cb6 = new JComboBox<String>(status);
		JTextField t7 = new JTextField(10);
		JTextField t8 = new JTextField(10);
		JTextField t9 = new JTextField(10);
		JTextField t10 = new JTextField(10);

		t1.setText(bookInfo[0]);
		t1.setEditable(false);
		t2.setText(bookInfo[1]);
		t2.setEditable(false);
		t3.setText(bookInfo[2]);
		t3.setEditable(false);
		t4.setText(bookInfo[3]);
		t4.setEditable(false);
		t5.setText(bookInfo[4]);
		t5.setEditable(false);
		cb6.setToolTipText(bookInfo[5]);
		cb6.setEnabled(false);
		t7.setText(bookInfo[6]);
		t7.setEditable(false);
		t8.setText(bookInfo[7]);
		t8.setEditable(false);
		t9.setText(bookInfo[8]);
		t9.setEditable(false);
		t10.setText(bookInfo[9]);
		t10.setEditable(false);

		p.add(l1);
		p.add(empty1);
		p.add(t1);
		p.add(l2);
		p.add(empty2);
		p.add(t2);
		p.add(l3);
		p.add(empty3);
		p.add(t3);
		p.add(l4);
		p.add(empty4);
		p.add(t4);
		p.add(l5);
		p.add(empty5);
		p.add(t5);
		p.add(l6);
		p.add(empty6);
		p.add(cb6);
		p.add(l7);
		p.add(empty7);
		p.add(t7);
		p.add(l8);
		p.add(empty8);
		p.add(t8);
		p.add(l9);
		p.add(empty9);
		p.add(t9);
		p.add(l10);
		p.add(empty10);
		p.add(t10);


		p.add(b1);
		p.add(b2);
		p.add(b3);

		add(p);

		b1.addActionListener(e -> {
			setVisible(false);
			new ListFrame();
		});

		b2.addActionListener(e -> {
			setVisible(false);
			new ModifyFrame(selectedBookTitle);
		});

		b3.addActionListener(e -> {
			int deleteResult = JOptionPane.showConfirmDialog(null, "정말 삭제 하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
		    if (deleteResult == JOptionPane.YES_OPTION) {
		        DeleteRepo dr = new DeleteRepo();
		        boolean result = dr.delete(selectedBookTitle);

		        if (result) {
		            JOptionPane.showMessageDialog(null, "삭제되었습니다.");
		            setVisible(false);
		            new ListFrame();
		        }
		    }
		});

	}



}