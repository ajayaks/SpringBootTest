package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.datacontract.schemas._2004._07.RESTfulWCFLG.DCU;
import org.datacontract.schemas._2004._07.RESTfulWCFLG.SLC;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.ILightingGaleServiceProxy;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(
        value = "/hello",
        description = "Metadata APIs"
)
@RestController
@RequestMapping(value="/hello")
public class SpringRestTestController {
	
	@RequestMapping
	@ApiOperation(value = "Returns user details", notes = "Returns a complete list of users details with a date of last modification.", response = User.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successful retrieval of user detail", response = User.class),
	    @ApiResponse(code = 404, message = "User with given username does not exist"),
	    @ApiResponse(code = 500, message = "Internal server error")})
	public String index()
	{
		return "Hello from spring Boot application index \n";
	}
	@ApiOperation(value = "Returns user details", notes = "Returns a complete list of users details with a date of last modification.", response = User.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successful retrieval of user detail", response = User.class),
	    @ApiResponse(code = 404, message = "User with given username does not exist"),
	    @ApiResponse(code = 500, message = "Internal server error")})
	 @RequestMapping(value = "/user", method = RequestMethod.GET)
	    public String getUserByName(@RequestParam(value = "name", defaultValue = "World") String name) {
	        return "Hello userbyName:  "+name;
	        //Will be accessed by http://localhost:8080/user?name=TOM as we have used @RequestParam so value is in param
	    }
	 
	 @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	    public String getUserById(@PathVariable(value = "id") String id) {
	        return "Hello userbyID :  "+id;
	        //Will be accessed by http://localhost:8080/user/25 as we have used @PathVariable so value is pathvariable
	    }
	 
	
	@RequestMapping(value = "/dcuList", method = RequestMethod.GET) 
	 public String dcutest() throws Exception
	 {
		 ILightingGaleServiceProxy proxy= new ILightingGaleServiceProxy();
		 DCU[] dcuVal = proxy.getAllDCUs("28");
		 DCU dcu = dcuVal[0];
		 return "dcu values from wsdl  "+dcu.getDCUId()+"::::";
		 
	 }
	
	
	
	@RequestMapping(value = "/slcsList", method = RequestMethod.GET) 
	 public String slctest() throws Exception
	 {
		 ILightingGaleServiceProxy proxy= new ILightingGaleServiceProxy();
		 SLC[] dcuVal = proxy.getAllSLCs("28");
		 StringBuilder builder= new StringBuilder();
		for(SLC slc:dcuVal)
		{
			builder.append(slc.getSLCName());
		}
		 return "SLCs values from wsdl  "+builder+"::::";
		 
	 }

   // @ApiOperation(value = "getGreeting", nickname = "getGreeting")
	
	@RequestMapping(value = "/slcsDetailsList", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE) 
	 public List<SLC> slcdetailstest() throws Exception
	 {
		 ILightingGaleServiceProxy proxy= new ILightingGaleServiceProxy();
		 SLC[] slcsArray = proxy.getAllSLCs("28");
		 List<SLC> slcsList=Arrays.asList(slcsArray);
		
		 return slcsList;
		 
	 }
	//Same response just using ResponseEntity instead of writing object as above
	@RequestMapping(value = "/slcsDetailsListResponseEntity", method = RequestMethod.GET) 
	 public ResponseEntity<?> dcutestagain() throws Exception
	 {
		ILightingGaleServiceProxy proxy= new ILightingGaleServiceProxy();
		 SLC[] slcsArray = proxy.getAllSLCs("28");
		 List<SLC> slcsList=Arrays.asList(slcsArray);
		
		 return new ResponseEntity<>(slcsList,HttpStatus.OK);
	 }
	 
	 
	 
	
	
	
	

}
