package com.example.controller;


import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import org.datacontract.schemas._2004._07.RESTfulWCFLG.Channels;
import org.datacontract.schemas._2004._07.RESTfulWCFLG.DCU;
import org.datacontract.schemas._2004._07.RESTfulWCFLG.Mode;
import org.datacontract.schemas._2004._07.RESTfulWCFLG.SLC;
import org.datacontract.schemas._2004._07.RESTfulWCFLG.SwitchOnOffDim;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.ILightingGaleServiceProxy;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api( value = "/lighting", description = "Operations with person")
@RestController
@RequestMapping(value = "/lighting", produces = MediaType.APPLICATION_JSON_VALUE)
public class LightingController<getAllDCUs> {

private static final String DCUs = null;
private Object abd;
@ApiOperation (value="dsdsds", notes=",asdasdas", response = User.class)

          @ResponseStatus(HttpStatus.ACCEPTED)
@RequestMapping(value = "/getAllDCUs/{clientId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE

)
@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successful retrieval of user detail", response = User.class),
	    @ApiResponse(code = 404, message = "User with given username does not exist"),
	    @ApiResponse(code = 500, message = "Internal server error")})
public ResponseEntity<?> getAllDCUs(@PathVariable(value = "clientId") String clientId) throws Exception {
// String clientId = String.valueOf(clientId1);
String idMsg = "clientId = " + clientId;
if (StringUtils.isEmpty(clientId)) {
return new ResponseEntity<>("Invalid url, " + idMsg, HttpStatus.BAD_REQUEST);
}

if (clientId == null) {
   return new ResponseEntity<>("DCU not found, " + idMsg, HttpStatus.NOT_FOUND);
}
ILightingGaleServiceProxy proxy = new ILightingGaleServiceProxy();
DCU[] dcuVal;
DCU dcu = null;
try {
dcuVal = proxy.getAllDCUs(clientId);
dcu = dcuVal[0];

} catch (RemoteException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
if (dcu == null) {
System.out.println("wsdl values::" + dcu.getDCUName() + "****" + dcu.getClientID() + "################"
+ dcu.getDCUId());
return new ResponseEntity<>("DCU details not found, " + idMsg, HttpStatus.NOT_FOUND);
}
   return new ResponseEntity<>(dcu, HttpStatus.OK);
   }
@ApiOperation (value="zzxzx", notes=",asdasdas", response = User.class)
    @ResponseStatus(HttpStatus.ACCEPTED)
@RequestMapping(value = "/getAllSLCs/{clientId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<?> getAllSLCs(@PathVariable(value = "clientId") String clientId) throws Exception {

ILightingGaleServiceProxy proxy = new ILightingGaleServiceProxy();
SLC[] dcuVal;
SLC dcu = null;
List<SLC> slcs = null;
try {
dcuVal = proxy.getAllSLCs(clientId);
slcs = Arrays.asList(dcuVal);

} catch (RemoteException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
if (dcu == null) {

}
return new ResponseEntity<>(slcs, HttpStatus.OK);
   }
    @ResponseStatus(HttpStatus.ACCEPTED)
@RequestMapping(value = "/getDCUById/{clientId}/{dcuId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<?> getDCUById(@PathVariable(value = "clientId") String clientId,
@PathVariable(value = "dcuId") String dcuId) throws Exception {

ILightingGaleServiceProxy proxy = new ILightingGaleServiceProxy();
DCU[] dcuVal;
DCU dcuResult = null;
List<DCU> slcs = null;
try {
dcuVal = proxy.getDCUById(clientId, dcuId);
dcuResult = dcuVal[0];

} catch (RemoteException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
if (dcuResult == null) {

}

return new ResponseEntity<>(dcuResult, HttpStatus.OK);
}
    @ResponseStatus(HttpStatus.ACCEPTED)
@RequestMapping(value = "/getSLCsByDCUId/{clientId}/{dcuId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<?> getSLCsByDCUId(@PathVariable(value = "clientId") String clientId,
@PathVariable(value = "dcuId") String dcuId) throws Exception {

ILightingGaleServiceProxy proxy = new ILightingGaleServiceProxy();
SLC[] slcVal;
SLC slcResult = null;
List<SLC> dcus = null;
try {
slcVal = proxy.getSLCsByDCUId(clientId, dcuId);
slcResult = slcVal[0];

} catch (RemoteException e) {
// TODO Auto-generated catch block
e.printStackTrace();

}
return new ResponseEntity<>(slcResult, HttpStatus.OK);
}
    @ResponseStatus(HttpStatus.ACCEPTED)
@RequestMapping(value = "/getSLCLocationDetailsById/{clientId}/{slcId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<?> getSLCLocationDetailsById(@PathVariable(value = "clientId") String clientId,
@PathVariable(value = "slcId") String slcId) throws Exception {

ILightingGaleServiceProxy proxy = new ILightingGaleServiceProxy();
SLC[] slcVal = null;
SLC slcResult = null;

try {
// slcVal2=proxy.getSLCLocationDetailsById("28","4146");
slcVal = proxy.getSLCLocationDetailsById(clientId, slcId);
slcResult = slcVal[0];
} catch (RemoteException e) {
e.printStackTrace();
}
return new ResponseEntity<>(slcResult, HttpStatus.OK);
}
    @ResponseStatus(HttpStatus.ACCEPTED)
@RequestMapping(value = "/getAllSLCLocationDetails/{clientId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<?> getAllSLCLocationDetails(@PathVariable(value = "clientId") String clientId)
throws Exception {

ILightingGaleServiceProxy proxy = new ILightingGaleServiceProxy();
SLC[] slcVal;
SLC slcResult = null;
try {
slcVal = proxy.getAllSLCLocationDetails(clientId);
slcResult = slcVal[0];
} catch (RemoteException e) {
e.printStackTrace();
}
return new ResponseEntity<>(slcResult, HttpStatus.OK);
}
    @ResponseStatus(HttpStatus.ACCEPTED)
@RequestMapping(value = "/getLatestReading/{clientId}/{dcuId}/{slcId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<?> getLatestReading(@PathVariable(value = "clientId") String clientId,
@PathVariable(value = "dcuId") String dcuId, @PathVariable(value = "slcId") String slcId) throws Exception {

ILightingGaleServiceProxy proxy = new ILightingGaleServiceProxy();
Channels[] channeVal;
Channels ChannelsResult = null;
List<SLC> dcus = null;
try {
channeVal = proxy.getLatestReading(clientId, dcuId, slcId);
ChannelsResult = channeVal[0];

} catch (RemoteException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

return new ResponseEntity<>(ChannelsResult, HttpStatus.OK);
}

    @ResponseStatus(HttpStatus.ACCEPTED)
@RequestMapping(value = "/Switchonoffdim/{clientId}/{dimming}/{gatewayId}/{slcIds}/{state}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<?> switchOnOffDim(@PathVariable(value = "clientId") Integer clientId,
@PathVariable(value = "dimming") Integer dimming, @PathVariable(value = "gatewayId") Integer gatewayId,
@PathVariable(value = "slcIds") String slcIds, @PathVariable(value = "state") Integer state)
throws Exception {
ILightingGaleServiceProxy proxy = new ILightingGaleServiceProxy();
Integer switchofResult = null;
SwitchOnOffDim SwitchOnOffDim = new SwitchOnOffDim();
SwitchOnOffDim.setClientId(clientId);
SwitchOnOffDim.setDimming(dimming);
SwitchOnOffDim.setGatewayId(gatewayId);
SwitchOnOffDim.setSLCIds(slcIds);
SwitchOnOffDim.setState(state);
try {
switchofResult = proxy.switchOnOffDim(SwitchOnOffDim);
} catch (RemoteException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return new ResponseEntity<>(switchofResult, HttpStatus.OK);
}
    @ResponseStatus(HttpStatus.ACCEPTED)
@RequestMapping(value = "/changeMode/{clientId}/{dimming}/{gatewayId}/{mode}/{state}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<?> changeMode(@PathVariable(value = "clientId") Integer clientId,
@PathVariable(value = "gatewayId") Integer gatewayId, @PathVariable(value = "mode") Integer mode,
@PathVariable(value = "slcIds") String slcIds, @PathVariable(value = "state") Integer state)
throws Exception {
ILightingGaleServiceProxy proxy = new ILightingGaleServiceProxy();
Integer modeResult = null;
Mode objMode = new Mode();
objMode.setClientId(clientId);
objMode.setGatewayId(gatewayId);
objMode.setMode(mode);
objMode.setSLCIds(slcIds);
try {
modeResult = proxy.changeMode(objMode);
} catch (RemoteException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return new ResponseEntity<>(modeResult, HttpStatus.OK);
}

}
