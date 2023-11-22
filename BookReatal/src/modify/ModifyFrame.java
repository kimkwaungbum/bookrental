package modify;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import detail.DetailFrame;
import modify.repo.ModifyRepo;

public class ModifyFrame extends JFrame{

	
	
	
	JButton b1 = new JButton("상세화면으로");
	JButton b2 = new JButton("수정");
	ModifyRepo mr = new ModifyRepo();



	public ModifyFrame(String selectedBookTitle) {

		setTitle("도서관리시스템 - 수정화면");
		setSize(400, 300);

		setPanel(selectedBookTitle);

		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void setPanel(String selectedBookTitle) {
		// TODO 自動生成されたメソッド・スタブ
		JPanel p = new JPanel(new GridLayout(0, 2));
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



		JTextField t1 = new JTextField(selectedBookTitle);

		JTextField t2 = new JTextField(10);

		JTextField t3 = new JTextField(10);
		
		JTextField t4 = new JTextField(10);
		
		JTextField t5 = new JTextField(10);
//		JTextField t6 = new JTextField(10);
		String[] status = {"대여중", "대여가능", "분실"};
		JComboBox<String> cb6 = new JComboBox<String>(status);
		JTextField t7 = new JTextField(10);
		JTextField t8 = new JTextField(10);
		JTextField t9 = new JTextField(10);
		JTextField t10 = new JTextField(10);
		
		
		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(t2);
		p.add(l3);
		p.add(t3);
		p.add(l4);
		p.add(t4);
		p.add(l5);
		p.add(t5);
		p.add(l6);
		p.add(cb6);
		p.add(l7);
		p.add(t7);
		p.add(l8);
		p.add(t8);
		p.add(l9);
		p.add(t9);
		p.add(l10);
		p.add(t10);


		p.add(b1);
		p.add(b2);

		add(p);

		b1.addActionListener(e-> {
			setVisible(false);
			new DetailFrame(selectedBookTitle);
		});
		b2.addActionListener(e-> {
			
			int no = mr.getNoByTitle(selectedBookTitle);

		    String category = t2.getText();
		    String writter = t3.getText();
		    String company = t4.getText();
		    int price = Integer.valueOf(t5.getText());
		    String bookstatus = cb6.getSelectedItem().toString();
		    String rental_user = t7.getText();
		    String return_day = t8.getText();
		    String rental_day = t9.getText();
		    int rental_price = Integer.valueOf(t10.getText());
			
			boolean result = mr.modify(selectedBookTitle, category, writter, company, price, bookstatus, rental_user, return_day, rental_day, rental_price,no);
			if(result) {
				JOptionPane.showConfirmDialog(null, "수정하시겠습니까?", "도서수정", JOptionPane.YES_NO_OPTION);
			}
			setVisible(false);
			new DetailFrame(selectedBookTitle);
			
		});

	}

//	public static void main(String[] args) {
//		new ModifyFrame(title);
//	}

}
