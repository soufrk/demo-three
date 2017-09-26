package designpatterns;

public class StrategyPattern01 {

	public static void main(String[] args) {
		GenericMcComponenet componenet = new V2ServiceComponent();
		componenet.acknowledgeBackResult();
		componenet = new V1ServiceComponent();
		componenet.acknowledgeBackResult();

	}

}

interface McComponentAble{
	
	String createPFTMessage();
	String createWFReqDTO();
	Boolean callService();
	
}

abstract class GenericMcComponenet implements McComponentAble{
	
	public String createPFTMessage(){
		System.out.println("GenericMcComponenet:Setting all required attributes for message.");
		return "Genereic MC Component: sending PFT message.......";
	}
	
	public String createWFReqDTO(){
		System.out.println("GenericMcComponenet:Setting all required attributes for WF Request.");
		return "Genereic MC Component: sending PFT message.......";
	}
	public Boolean callService(){
		System.out.println("GenericMcComponenet:Making call to MC.....");
		return true; 
	}
	
	public void acknowledgeBackResult(){
		
		// 1. Create a WF Request 
		createWFReqDTO();
		// 2. Create a PFT Message with Progress DTO
		createPFTMessage();
		// 3. Make Call to MC
		callService();
	}
}

class V1ServiceComponent extends GenericMcComponenet{
	
}

class V2ServiceComponent extends GenericMcComponenet{

	//public submitJob();
	public void getProgress(){
		System.out.println("V2ServiceComponent:Fetching status information from the component...");
		System.out.println("V2ServiceComponent:Delegating call-back to Base Class.");
		acknowledgeBackResult();
	}
	
	@Override
	public String createPFTMessage() {
		System.out.println("V2ServiceComponent:Setting all required attributes for message.");
		return super.createPFTMessage();
	}
	
}