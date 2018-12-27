package microservice.url;

/**
 * @Description:  部门微服务8001对外服务远程调用的提供的url
 * @Author：pengrj
 * @Date : 2018/12/24 0024 21:06
 * @version:1.0
 */

public class DeptMircServiceUrl {

    // private static   final String REST_DEPT_8001_PREURL="http://localhost:8001";

    //Ribbon Eureka整合后8001 8005可以直接调用Dept微服务而不再关心地址和端口
    //DEPT-COM.DEPT.SERVICE 就是部门8001 8005微服务在eureka注册的实例名称
    private static   final String REST_DEPT_PREURL="http://DEPT-COM.DEPT.SERVICE";

    public static final String DEPT_ADD=REST_DEPT_PREURL+"/dept/add";

    public static final String DEPT_GETDEPT_LIST=REST_DEPT_PREURL+"/dept/list";

    public static String Dept_Getdept_ById_URL(String id ){
        return  REST_DEPT_PREURL+"/dept/get/"+id;
    }



}
