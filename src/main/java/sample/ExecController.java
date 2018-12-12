package sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // (1)
public class ExecController {
	@RequestMapping("/1") // URLが/helloのときにhelloメソッドを呼ぶ
	public String Exec1() {
		String s;
		s = Run.Exec1();
		return s;
	}

	@RequestMapping("/2")
	public String Exec2() {
		String s = Run.Exec2();
		return s;
	}

	@RequestMapping("/3")
	public String Exec3() {
		String s = Run.Exec3();
		return s;
	}

}