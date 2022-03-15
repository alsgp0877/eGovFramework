package egoveframework.sample.common;

import java.sql.SQLException;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

import egoveframework.sample.vo.SampleVO;

public class AdvancedSampleAdvice {

	public void beforeLogic(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[사전처리]" +method+"()메소드 ARGS 정보:"+args[0].toString());
		
	}
	public void afterLogic(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		System.out.println("[사후처리]"+ method +"() 비즈니스 로직 수행 후 동작");
		if(returnObj instanceof List) {
			List<SampleVO> sampleList = (List<SampleVO>)returnObj;
			System.out.println("검색된데이터"+ sampleList.size()+ "건" );
			
		}
		
	}
	
	public Object aroundLogic(ProceedingJoinPoint pjp) throws Throwable {
		
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
	
		Object obj = pjp.proceed();
		
		
		stopWatch.stop();
		System.out.println(method+"()메소드 수행에 걸린시간:"+stopWatch.getTotalTimeMillis()+"(ms)초");
		return obj;
		
	}
	
	public void afterThrowingLogic(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println("[사후처리]"+ method +"() 메소드 수행 중 예외 발생!");
		if(exceptObj instanceof IllegalArgumentException) {//instanceof : 연산자는 객체가 어떤 클래스인지, 어떤 클래스를 상속받았는지 확인하는데 사용하는 연산자입니다  true/false로 
			System.out.println("부적절한 아규먼트 정보가 입력되었습니다.");
		}else if(exceptObj instanceof SQLException) {
			System.out.println("데이터베이스 연동에 문제가 생겼습니다.");
		}else {
			System.out.println("문제발생!");
		}
		
	}

}
