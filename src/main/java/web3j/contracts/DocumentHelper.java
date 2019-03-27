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
    private static final String BINARY = "0x608060405234801561001057600080fd5b506127e2806100206000396000f3fe6080604052600436106100ba576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806307e74028146100bf5780630afdb2c41461013a5780632bb4b1fc1461019f5780633f9b250a146102455780635af7adeb1461043d5780636bdd265f146107285780637fd12d94146107ce5780638789c4cb14610a5b578063b1d5126c14610b37578063d48393c214610bdd578063d9b927f214610c42578063e45babe314610ca7575b600080fd5b3480156100cb57600080fd5b50610138600480360360608110156100e257600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610f54565b005b34801561014657600080fd5b506101896004803603602081101561015d57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611099565b6040518082815260200191505060405180910390f35b3480156101ab57600080fd5b506101ee600480360360208110156101c257600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506111a3565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b83811015610231578082015181840152602081019050610216565b505050509050019250505060405180910390f35b34801561025157600080fd5b5061027e6004803603602081101561026857600080fd5b810190808035906020019092919050505061130f565b6040518080602001806020018060200180602001858103855289818151815260200191508051906020019080838360005b838110156102ca5780820151818401526020810190506102af565b50505050905090810190601f1680156102f75780820380516001836020036101000a031916815260200191505b50858103845288818151815260200191508051906020019080838360005b83811015610330578082015181840152602081019050610315565b50505050905090810190601f16801561035d5780820380516001836020036101000a031916815260200191505b50858103835287818151815260200191508051906020019080838360005b8381101561039657808201518184015260208101905061037b565b50505050905090810190601f1680156103c35780820380516001836020036101000a031916815260200191505b50858103825286818151815260200191508051906020019080838360005b838110156103fc5780820151818401526020810190506103e1565b50505050905090810190601f1680156104295780820380516001836020036101000a031916815260200191505b509850505050505050505060405180910390f35b34801561044957600080fd5b506105036004803603602081101561046057600080fd5b810190808035906020019064010000000081111561047d57600080fd5b82018360208201111561048f57600080fd5b803590602001918460018302840111640100000000831117156104b157600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050611660565b60405180806020018060200180602001806020018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200185810385528b818151815260200191508051906020019080838360005b838110156105b3578082015181840152602081019050610598565b50505050905090810190601f1680156105e05780820380516001836020036101000a031916815260200191505b5085810384528a818151815260200191508051906020019080838360005b838110156106195780820151818401526020810190506105fe565b50505050905090810190601f1680156106465780820380516001836020036101000a031916815260200191505b50858103835289818151815260200191508051906020019080838360005b8381101561067f578082015181840152602081019050610664565b50505050905090810190601f1680156106ac5780820380516001836020036101000a031916815260200191505b50858103825288818151815260200191508051906020019080838360005b838110156106e55780820151818401526020810190506106ca565b50505050905090810190601f1680156107125780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390f35b34801561073457600080fd5b506107776004803603602081101561074b57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611b69565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156107ba57808201518184015260208101905061079f565b505050509050019250505060405180910390f35b3480156107da57600080fd5b50610a59600480360360808110156107f157600080fd5b810190808035906020019064010000000081111561080e57600080fd5b82018360208201111561082057600080fd5b8035906020019184600183028401116401000000008311171561084257600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156108a557600080fd5b8201836020820111156108b757600080fd5b803590602001918460018302840111640100000000831117156108d957600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561093c57600080fd5b82018360208201111561094e57600080fd5b8035906020019184600183028401116401000000008311171561097057600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156109d357600080fd5b8201836020820111156109e557600080fd5b80359060200191846001830284011164010000000083111715610a0757600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050611cd6565b005b348015610a6757600080fd5b50610b2160048036036020811015610a7e57600080fd5b8101908080359060200190640100000000811115610a9b57600080fd5b820183602082011115610aad57600080fd5b80359060200191846001830284011164010000000083111715610acf57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192905050506120a4565b6040518082815260200191505060405180910390f35b348015610b4357600080fd5b50610b8660048036036020811015610b5a57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050612119565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b83811015610bc9578082015181840152602081019050610bae565b505050509050019250505060405180910390f35b348015610be957600080fd5b50610c2c60048036036020811015610c0057600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061221a565b6040518082815260200191505060405180910390f35b348015610c4e57600080fd5b50610c9160048036036020811015610c6557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506122b9565b6040518082815260200191505060405180910390f35b348015610cb357600080fd5b50610f52600480360360a0811015610cca57600080fd5b8101908080359060200190640100000000811115610ce757600080fd5b820183602082011115610cf957600080fd5b80359060200191846001830284011164010000000083111715610d1b57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929080359060200190640100000000811115610d7e57600080fd5b820183602082011115610d9057600080fd5b80359060200191846001830284011164010000000083111715610db257600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929080359060200190640100000000811115610e1557600080fd5b820183602082011115610e2757600080fd5b80359060200191846001830284011164010000000083111715610e4957600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929080359060200190640100000000811115610eac57600080fd5b820183602082011115610ebe57600080fd5b80359060200191846001830284011164010000000083111715610ee057600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506123c4565b005b816003600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600081548092919060010191905055507fb6a2b86a4a372aa391ce5b6def153f9d88d518c36b6688a9aab5be59ee6840d8838383604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390a1505050565b6000806000905060008090505b600080549050811015611199578373ffffffffffffffffffffffffffffffffffffffff166001600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480156111805750600073ffffffffffffffffffffffffffffffffffffffff166003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b1561118c576001820191505b80806001019150506110a6565b5080915050919050565b606060006111b083611099565b90506060816040519080825280602002602001820160405280156111e35781602001602082028038833980820191505090505b509050600080905060008090505b600080549050811015611303578573ffffffffffffffffffffffffffffffffffffffff166001600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480156112cb5750600073ffffffffffffffffffffffffffffffffffffffff166003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b156112f6578083838151811015156112df57fe5b906020019060200201818152505081806001019250505b80806001019150506111f1565b50819350505050919050565b606080606080600080549050851015156113745760206040519081016040528060008152506020604051908101604052806000815250602060405190810160405280600081525060206040519081016040528060008152509350935093509350611659565b61137c6126e8565b60008681548110151561138b57fe5b906000526020600020906004020160806040519081016040529081600082018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561143e5780601f106114135761010080835404028352916020019161143e565b820191906000526020600020905b81548152906001019060200180831161142157829003601f168201915b50505050508152602001600182018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156114e05780601f106114b5576101008083540402835291602001916114e0565b820191906000526020600020905b8154815290600101906020018083116114c357829003601f168201915b50505050508152602001600282018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156115825780601f1061155757610100808354040283529160200191611582565b820191906000526020600020905b81548152906001019060200180831161156557829003601f168201915b50505050508152602001600382018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156116245780601f106115f957610100808354040283529160200191611624565b820191906000526020600020905b81548152906001019060200180831161160757829003601f168201915b505050505081525050905080600001518160200151826040015183606001518393508292508191508090509450945094509450505b9193509193565b60608060608060008060008090505b600080549050811015611afe57876040516020018082805190602001908083835b6020831015156116b55780518252602082019150602081019050602083039250611690565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051602081830303815290604052805190602001206000828154811015156116ff57fe5b9060005260206000209060040201600001604051602001808280546001816001161561010002031660029004801561176e5780601f1061174c57610100808354040283529182019161176e565b820191906000526020600020905b81548152906001019060200180831161175a575b5050915050604051602081830303815290604052805190602001201415611af1576117976126e8565b6000828154811015156117a657fe5b906000526020600020906004020160806040519081016040529081600082018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156118595780601f1061182e57610100808354040283529160200191611859565b820191906000526020600020905b81548152906001019060200180831161183c57829003601f168201915b50505050508152602001600182018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156118fb5780601f106118d0576101008083540402835291602001916118fb565b820191906000526020600020905b8154815290600101906020018083116118de57829003601f168201915b50505050508152602001600282018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561199d5780601f106119725761010080835404028352916020019161199d565b820191906000526020600020905b81548152906001019060200180831161198057829003601f168201915b50505050508152602001600382018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611a3f5780601f10611a1457610100808354040283529160200191611a3f565b820191906000526020600020905b815481529060010190602001808311611a2257829003601f168201915b505050505081525050905060006001600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905060006003600085815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690508260000151836020015184604001518560600151858585955084945083935082925099509950995099509950995050505050611b60565b808060010191505061166f565b506000809050808160206040519081016040528060008152509190602060405190810160405280600081525091906020604051908101604052806000815250919060206040519081016040528060008152509190965096509650965096509650505b91939550919395565b60606000611b76836122b9565b9050606081604051908082528060200260200182016040528015611ba95781602001602082028038833980820191505090505b509050600080905060008090505b600080549050811015611cca578573ffffffffffffffffffffffffffffffffffffffff166001600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16148015611c925750600073ffffffffffffffffffffffffffffffffffffffff166003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614155b15611cbd57808383815181101515611ca657fe5b906020019060200201818152505081806001019250505b8080600101915050611bb7565b50819350505050919050565b60006001600060806040519081016040528088815260200187815260200186815260200185815250908060018154018082558091505090600182039060005260206000209060040201600090919290919091506000820151816000019080519060200190611d45929190612711565b506020820151816001019080519060200190611d62929190612711565b506040820151816002019080519060200190611d7f929190612711565b506060820151816003019080519060200190611d9c929190612711565b505050039050336001600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282540192505081905550806004866040518082805190602001908083835b602083101515611e7b5780518252602082019150602081019050602083039250611e56565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020819055507f1139f7a9aa41bbea144de2725ec4dc91f8f17ef6598410087d798572e938b4e181868686866040518086815260200180602001806020018060200180602001858103855289818151815260200191508051906020019080838360005b83811015611f2a578082015181840152602081019050611f0f565b50505050905090810190601f168015611f575780820380516001836020036101000a031916815260200191505b50858103845288818151815260200191508051906020019080838360005b83811015611f90578082015181840152602081019050611f75565b50505050905090810190601f168015611fbd5780820380516001836020036101000a031916815260200191505b50858103835287818151815260200191508051906020019080838360005b83811015611ff6578082015181840152602081019050611fdb565b50505050905090810190601f1680156120235780820380516001836020036101000a031916815260200191505b50858103825286818151815260200191508051906020019080838360005b8381101561205c578082015181840152602081019050612041565b50505050905090810190601f1680156120895780820380516001836020036101000a031916815260200191505b50995050505050505050505060405180910390a15050505050565b60006004826040518082805190602001908083835b6020831015156120de57805182526020820191506020810190506020830392506120b9565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020549050919050565b606060006121268361221a565b90506060816040519080825280602002602001820160405280156121595781602001602082028038833980820191505090505b509050600080905060008090505b60008054905081101561220e578573ffffffffffffffffffffffffffffffffffffffff166003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415612201578083838151811015156121ea57fe5b906020019060200201818152505081806001019250505b8080600101915050612167565b50819350505050919050565b6000806000905060008090505b6000805490508110156122af578373ffffffffffffffffffffffffffffffffffffffff166003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156122a2576001820191505b8080600101915050612227565b5080915050919050565b6000806000905060008090505b6000805490508110156123ba578373ffffffffffffffffffffffffffffffffffffffff166001600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480156123a15750600073ffffffffffffffffffffffffffffffffffffffff166003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614155b156123ad576001820191505b80806001019150506122c6565b5080915050919050565b60006001600060806040519081016040528089815260200188815260200187815260200186815250908060018154018082558091505090600182039060005260206000209060040201600090919290919091506000820151816000019080519060200190612433929190612711565b506020820151816001019080519060200190612450929190612711565b50604082015181600201908051906020019061246d929190612711565b50606082015181600301908051906020019061248a929190612711565b505050039050336001600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282540192505081905550806004876040518082805190602001908083835b6020831015156125695780518252602082019150602081019050602083039250612544565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902081905550816003600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600081548092919060010191905055507fb6a2b86a4a372aa391ce5b6def153f9d88d518c36b6688a9aab5be59ee6840d8338383604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390a1505050505050565b608060405190810160405280606081526020016060815260200160608152602001606081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061275257805160ff1916838001178555612780565b82800160010185558215612780579182015b8281111561277f578251825591602001919060010190612764565b5b50905061278d9190612791565b5090565b6127b391905b808211156127af576000816000905550600101612797565b5090565b9056fea165627a7a723058208e6b31a5ad05ff5f86244a57d5305a0e89b4684c37a0de17a872c38dea77d6a80029";

    public static final String FUNC_TRANSFERDOCUMENT = "transferDocument";

    public static final String FUNC_COUNTDOCUMENTSUNISSUED = "countDocumentsUnissued";

    public static final String FUNC_CREATEDOCUMENT = "createDocument";

    public static final String FUNC_GETINDEXFROMHASH = "getIndexFromHash";

    public static final String FUNC_COUNTDOCUMENTSRECEIVED = "countDocumentsReceived";

    public static final String FUNC_COUNTDOCUMENTSISSUED = "countDocumentsIssued";

    public static final String FUNC_CREATEANDISSUEDOCUMENT = "createAndIssueDocument";

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

    public RemoteCall<TransactionReceipt> createAndIssueDocument(String _documentHash, String _name, String _url, String _description, String _receiver) {
        final Function function = new Function(
                FUNC_CREATEANDISSUEDOCUMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_documentHash), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_url), 
                new org.web3j.abi.datatypes.Utf8String(_description), 
                new org.web3j.abi.datatypes.Address(_receiver)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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
