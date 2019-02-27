package web3j.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.1.1.
 */
public class DocumentHelper extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b50612206806100206000396000f3fe6080604052600436106100af576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806307e74028146100b45780630afdb2c41461012f5780632bb4b1fc146101945780633f9b250a1461023a5780635af7adeb146104325780636bdd265f1461071d5780637fd12d94146107c35780638789c4cb14610a50578063b1d5126c14610b2c578063d48393c214610bd2578063d9b927f214610c37575b600080fd5b3480156100c057600080fd5b5061012d600480360360608110156100d757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610c9c565b005b34801561013b57600080fd5b5061017e6004803603602081101561015257600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610de1565b6040518082815260200191505060405180910390f35b3480156101a057600080fd5b506101e3600480360360208110156101b757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610eeb565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561022657808201518184015260208101905061020b565b505050509050019250505060405180910390f35b34801561024657600080fd5b506102736004803603602081101561025d57600080fd5b8101908080359060200190929190505050611057565b6040518080602001806020018060200180602001858103855289818151815260200191508051906020019080838360005b838110156102bf5780820151818401526020810190506102a4565b50505050905090810190601f1680156102ec5780820380516001836020036101000a031916815260200191505b50858103845288818151815260200191508051906020019080838360005b8381101561032557808201518184015260208101905061030a565b50505050905090810190601f1680156103525780820380516001836020036101000a031916815260200191505b50858103835287818151815260200191508051906020019080838360005b8381101561038b578082015181840152602081019050610370565b50505050905090810190601f1680156103b85780820380516001836020036101000a031916815260200191505b50858103825286818151815260200191508051906020019080838360005b838110156103f15780820151818401526020810190506103d6565b50505050905090810190601f16801561041e5780820380516001836020036101000a031916815260200191505b509850505050505050505060405180910390f35b34801561043e57600080fd5b506104f86004803603602081101561045557600080fd5b810190808035906020019064010000000081111561047257600080fd5b82018360208201111561048457600080fd5b803590602001918460018302840111640100000000831117156104a657600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192905050506113a8565b60405180806020018060200180602001806020018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200185810385528b818151815260200191508051906020019080838360005b838110156105a857808201518184015260208101905061058d565b50505050905090810190601f1680156105d55780820380516001836020036101000a031916815260200191505b5085810384528a818151815260200191508051906020019080838360005b8381101561060e5780820151818401526020810190506105f3565b50505050905090810190601f16801561063b5780820380516001836020036101000a031916815260200191505b50858103835289818151815260200191508051906020019080838360005b83811015610674578082015181840152602081019050610659565b50505050905090810190601f1680156106a15780820380516001836020036101000a031916815260200191505b50858103825288818151815260200191508051906020019080838360005b838110156106da5780820151818401526020810190506106bf565b50505050905090810190601f1680156107075780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390f35b34801561072957600080fd5b5061076c6004803603602081101561074057600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506118b1565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156107af578082015181840152602081019050610794565b505050509050019250505060405180910390f35b3480156107cf57600080fd5b50610a4e600480360360808110156107e657600080fd5b810190808035906020019064010000000081111561080357600080fd5b82018360208201111561081557600080fd5b8035906020019184600183028401116401000000008311171561083757600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561089a57600080fd5b8201836020820111156108ac57600080fd5b803590602001918460018302840111640100000000831117156108ce57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561093157600080fd5b82018360208201111561094357600080fd5b8035906020019184600183028401116401000000008311171561096557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156109c857600080fd5b8201836020820111156109da57600080fd5b803590602001918460018302840111640100000000831117156109fc57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050611a1e565b005b348015610a5c57600080fd5b50610b1660048036036020811015610a7357600080fd5b8101908080359060200190640100000000811115610a9057600080fd5b820183602082011115610aa257600080fd5b80359060200191846001830284011164010000000083111715610ac457600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050611dec565b6040518082815260200191505060405180910390f35b348015610b3857600080fd5b50610b7b60048036036020811015610b4f57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611e61565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b83811015610bbe578082015181840152602081019050610ba3565b505050509050019250505060405180910390f35b348015610bde57600080fd5b50610c2160048036036020811015610bf557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611f62565b6040518082815260200191505060405180910390f35b348015610c4357600080fd5b50610c8660048036036020811015610c5a57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050612001565b6040518082815260200191505060405180910390f35b816003600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600081548092919060010191905055507fb6a2b86a4a372aa391ce5b6def153f9d88d518c36b6688a9aab5be59ee6840d8838383604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390a1505050565b6000806000905060008090505b600080549050811015610ee1578373ffffffffffffffffffffffffffffffffffffffff166001600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16148015610ec85750600073ffffffffffffffffffffffffffffffffffffffff166003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b15610ed4576001820191505b8080600101915050610dee565b5080915050919050565b60606000610ef883610de1565b9050606081604051908082528060200260200182016040528015610f2b5781602001602082028038833980820191505090505b509050600080905060008090505b60008054905081101561104b578573ffffffffffffffffffffffffffffffffffffffff166001600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480156110135750600073ffffffffffffffffffffffffffffffffffffffff166003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b1561103e5780838381518110151561102757fe5b906020019060200201818152505081806001019250505b8080600101915050610f39565b50819350505050919050565b606080606080600080549050851015156110bc57602060405190810160405280600081525060206040519081016040528060008152506020604051908101604052806000815250602060405190810160405280600081525093509350935093506113a1565b6110c461210c565b6000868154811015156110d357fe5b906000526020600020906004020160806040519081016040529081600082018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156111865780601f1061115b57610100808354040283529160200191611186565b820191906000526020600020905b81548152906001019060200180831161116957829003601f168201915b50505050508152602001600182018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156112285780601f106111fd57610100808354040283529160200191611228565b820191906000526020600020905b81548152906001019060200180831161120b57829003601f168201915b50505050508152602001600282018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156112ca5780601f1061129f576101008083540402835291602001916112ca565b820191906000526020600020905b8154815290600101906020018083116112ad57829003601f168201915b50505050508152602001600382018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561136c5780601f106113415761010080835404028352916020019161136c565b820191906000526020600020905b81548152906001019060200180831161134f57829003601f168201915b505050505081525050905080600001518160200151826040015183606001518393508292508191508090509450945094509450505b9193509193565b60608060608060008060008090505b60008054905081101561184657876040516020018082805190602001908083835b6020831015156113fd57805182526020820191506020810190506020830392506113d8565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040516020818303038152906040528051906020012060008281548110151561144757fe5b906000526020600020906004020160000160405160200180828054600181600116156101000203166002900480156114b65780601f106114945761010080835404028352918201916114b6565b820191906000526020600020905b8154815290600101906020018083116114a2575b5050915050604051602081830303815290604052805190602001201415611839576114df61210c565b6000828154811015156114ee57fe5b906000526020600020906004020160806040519081016040529081600082018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156115a15780601f10611576576101008083540402835291602001916115a1565b820191906000526020600020905b81548152906001019060200180831161158457829003601f168201915b50505050508152602001600182018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156116435780601f1061161857610100808354040283529160200191611643565b820191906000526020600020905b81548152906001019060200180831161162657829003601f168201915b50505050508152602001600282018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156116e55780601f106116ba576101008083540402835291602001916116e5565b820191906000526020600020905b8154815290600101906020018083116116c857829003601f168201915b50505050508152602001600382018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156117875780601f1061175c57610100808354040283529160200191611787565b820191906000526020600020905b81548152906001019060200180831161176a57829003601f168201915b505050505081525050905060006001600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905060006003600085815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905082600001518360200151846040015185606001518585859550849450839350829250995099509950995099509950505050506118a8565b80806001019150506113b7565b506000809050808160206040519081016040528060008152509190602060405190810160405280600081525091906020604051908101604052806000815250919060206040519081016040528060008152509190965096509650965096509650505b91939550919395565b606060006118be83612001565b90506060816040519080825280602002602001820160405280156118f15781602001602082028038833980820191505090505b509050600080905060008090505b600080549050811015611a12578573ffffffffffffffffffffffffffffffffffffffff166001600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480156119da5750600073ffffffffffffffffffffffffffffffffffffffff166003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614155b15611a05578083838151811015156119ee57fe5b906020019060200201818152505081806001019250505b80806001019150506118ff565b50819350505050919050565b60006001600060806040519081016040528088815260200187815260200186815260200185815250908060018154018082558091505090600182039060005260206000209060040201600090919290919091506000820151816000019080519060200190611a8d929190612135565b506020820151816001019080519060200190611aaa929190612135565b506040820151816002019080519060200190611ac7929190612135565b506060820151816003019080519060200190611ae4929190612135565b505050039050336001600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282540192505081905550806004866040518082805190602001908083835b602083101515611bc35780518252602082019150602081019050602083039250611b9e565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020819055507f1139f7a9aa41bbea144de2725ec4dc91f8f17ef6598410087d798572e938b4e181868686866040518086815260200180602001806020018060200180602001858103855289818151815260200191508051906020019080838360005b83811015611c72578082015181840152602081019050611c57565b50505050905090810190601f168015611c9f5780820380516001836020036101000a031916815260200191505b50858103845288818151815260200191508051906020019080838360005b83811015611cd8578082015181840152602081019050611cbd565b50505050905090810190601f168015611d055780820380516001836020036101000a031916815260200191505b50858103835287818151815260200191508051906020019080838360005b83811015611d3e578082015181840152602081019050611d23565b50505050905090810190601f168015611d6b5780820380516001836020036101000a031916815260200191505b50858103825286818151815260200191508051906020019080838360005b83811015611da4578082015181840152602081019050611d89565b50505050905090810190601f168015611dd15780820380516001836020036101000a031916815260200191505b50995050505050505050505060405180910390a15050505050565b60006004826040518082805190602001908083835b602083101515611e265780518252602082019150602081019050602083039250611e01565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020549050919050565b60606000611e6e83611f62565b9050606081604051908082528060200260200182016040528015611ea15781602001602082028038833980820191505090505b509050600080905060008090505b600080549050811015611f56578573ffffffffffffffffffffffffffffffffffffffff166003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415611f4957808383815181101515611f3257fe5b906020019060200201818152505081806001019250505b8080600101915050611eaf565b50819350505050919050565b6000806000905060008090505b600080549050811015611ff7578373ffffffffffffffffffffffffffffffffffffffff166003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415611fea576001820191505b8080600101915050611f6f565b5080915050919050565b6000806000905060008090505b600080549050811015612102578373ffffffffffffffffffffffffffffffffffffffff166001600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480156120e95750600073ffffffffffffffffffffffffffffffffffffffff166003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614155b156120f5576001820191505b808060010191505061200e565b5080915050919050565b608060405190810160405280606081526020016060815260200160608152602001606081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061217657805160ff19168380011785556121a4565b828001600101855582156121a4579182015b828111156121a3578251825591602001919060010190612188565b5b5090506121b191906121b5565b5090565b6121d791905b808211156121d35760008160009055506001016121bb565b5090565b9056fea165627a7a72305820467b505ad81140f2c748941240c0a74e38706909493eb7c540c6a88594ef3ec50029";

    public static final String FUNC_TRANSFERDOCUMENT = "transferDocument";

    public static final String FUNC_COUNTDOCUMENTSUNISSUED = "countDocumentsUnissued";

    public static final String FUNC_CREATEDOCUMENT = "createDocument";

    public static final String FUNC_GETINDEXFROMHASH = "getIndexFromHash";

    public static final String FUNC_COUNTDOCUMENTSRECEIVED = "countDocumentsReceived";

    public static final String FUNC_COUNTDOCUMENTSISSUED = "countDocumentsIssued";

    public static final String FUNC_GETDOCUMENTSRECEIVED = "getDocumentsReceived";

    public static final String FUNC_GETDOCUMENTSISSUED = "getDocumentsIssued";

    public static final String FUNC_GETDOCUMENTSUNISSUED = "getDocumentsUnissued";

    public static final String FUNC_GETDOCUMENT = "getDocument";

    public static final String FUNC_GETDOCUMENTBYHASH = "getDocumentByHash";

    public static final Event DOCUMENTTRANSFERRED_EVENT = new Event("DocumentTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event DOCUMENTCREATED_EVENT = new Event("DocumentCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("5777", "0xb02139e1e0658CB8855595E5089875521cB2307B");
    }

    @Deprecated
    protected DocumentHelper(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DocumentHelper(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DocumentHelper(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DocumentHelper(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> transferDocument(String _from, String _to, BigInteger _docId) {
        final Function function = new Function(
                FUNC_TRANSFERDOCUMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_docId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> countDocumentsUnissued(String _owner) {
        final Function function = new Function(FUNC_COUNTDOCUMENTSUNISSUED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> createDocument(String _documentHash, String _name, String _url, String _description) {
        final Function function = new Function(
                FUNC_CREATEDOCUMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_documentHash), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_url), 
                new org.web3j.abi.datatypes.Utf8String(_description)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getIndexFromHash(String _documentHash) {
        final Function function = new Function(FUNC_GETINDEXFROMHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_documentHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> countDocumentsReceived(String _owner) {
        final Function function = new Function(FUNC_COUNTDOCUMENTSRECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> countDocumentsIssued(String _owner) {
        final Function function = new Function(FUNC_COUNTDOCUMENTSISSUED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public List<DocumentTransferredEventResponse> getDocumentTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DOCUMENTTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<DocumentTransferredEventResponse> responses = new ArrayList<DocumentTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DocumentTransferredEventResponse typedResponse = new DocumentTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._docId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DocumentTransferredEventResponse> documentTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, DocumentTransferredEventResponse>() {
            @Override
            public DocumentTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DOCUMENTTRANSFERRED_EVENT, log);
                DocumentTransferredEventResponse typedResponse = new DocumentTransferredEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._docId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DocumentTransferredEventResponse> documentTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DOCUMENTTRANSFERRED_EVENT));
        return documentTransferredEventFlowable(filter);
    }

    public List<DocumentCreatedEventResponse> getDocumentCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DOCUMENTCREATED_EVENT, transactionReceipt);
        ArrayList<DocumentCreatedEventResponse> responses = new ArrayList<DocumentCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DocumentCreatedEventResponse typedResponse = new DocumentCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.docId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.documentHash = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.name = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.url = (String) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.description = (String) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DocumentCreatedEventResponse> documentCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, DocumentCreatedEventResponse>() {
            @Override
            public DocumentCreatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DOCUMENTCREATED_EVENT, log);
                DocumentCreatedEventResponse typedResponse = new DocumentCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.docId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.documentHash = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.name = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.url = (String) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.description = (String) eventValues.getNonIndexedValues().get(4).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DocumentCreatedEventResponse> documentCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DOCUMENTCREATED_EVENT));
        return documentCreatedEventFlowable(filter);
    }

    public RemoteCall<List> getDocumentsReceived(String _owner) {
        final Function function = new Function(FUNC_GETDOCUMENTSRECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<List> getDocumentsIssued(String _owner) {
        final Function function = new Function(FUNC_GETDOCUMENTSISSUED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<List> getDocumentsUnissued(String _owner) {
        final Function function = new Function(FUNC_GETDOCUMENTSUNISSUED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<Tuple4<String, String, String, String>> getDocument(BigInteger _id) {
        final Function function = new Function(FUNC_GETDOCUMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple4<String, String, String, String>>(
                new Callable<Tuple4<String, String, String, String>>() {
                    @Override
                    public Tuple4<String, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<Tuple6<String, String, String, String, String, String>> getDocumentByHash(String _documentHash) {
        final Function function = new Function(FUNC_GETDOCUMENTBYHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_documentHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple6<String, String, String, String, String, String>>(
                new Callable<Tuple6<String, String, String, String, String, String>>() {
                    @Override
                    public Tuple6<String, String, String, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<String, String, String, String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue());
                    }
                });
    }

    @Deprecated
    public static DocumentHelper load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DocumentHelper(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DocumentHelper load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DocumentHelper(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DocumentHelper load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DocumentHelper(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DocumentHelper load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DocumentHelper(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DocumentHelper> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DocumentHelper.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DocumentHelper> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DocumentHelper.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<DocumentHelper> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DocumentHelper.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DocumentHelper> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DocumentHelper.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class DocumentTransferredEventResponse {
        public Log log;

        public String _from;

        public String _to;

        public BigInteger _docId;
    }

    public static class DocumentCreatedEventResponse {
        public Log log;

        public BigInteger docId;

        public String documentHash;

        public String name;

        public String url;

        public String description;
    }
}
