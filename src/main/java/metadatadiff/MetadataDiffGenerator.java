package metadatadiff;

import java.util.HashMap;
import java.util.Map;

import metadatadiff.MetadataDiff;

public class MetadataDiffGenerator {

    public static MetadataDiff getMetadataDiff() {

    	Map<String, Integer> subclassIds = new HashMap<String, Integer>();
    	subclassIds.put("Hello", 1);
    	subclassIds.put("Hello$ReferenceClass", 0);
    	Map<String, Integer> fieldIds = new HashMap<String, Integer>();
    	fieldIds.put("Hello.hello", 0);
    	Map<String, Integer> methodIds = new HashMap<String, Integer>();
    	methodIds.put("equals(Ljava/lang/Object;)Z", 12);
    	methodIds.put("getAccountId(Lcom/twitter/macaw/Request;)Lscala/Option;", 4);
    	methodIds.put("hashCode()I", 14);
    	methodIds.put("spyModeAllowed(Lcom/twitter/ads/web/filters/AdsRequest;Lcom/twitter/birdherd/User;)Z", 6);
    	methodIds.put("toString()Ljava/lang/String;", 15);
    	methodIds.put("thisOneNeither(Lcom/twitter/ads/web/filters/AccountFilter;)V", 10);
    	methodIds.put("apply(Lcom/twitter/macaw/Request;Lcom/twitter/finagle/Service;)Lcom/twitter/util/Future;", 0);
    	methodIds.put("neverCallThis(Lcom/twitter/ads/web/config/AdsMacawWeb;Lcom/twitter/macaw/birdherd/config/BirdherdMacawProfile;)V", 9);
    	methodIds.put("apply(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 2);
    	methodIds.put("getAccount(Lcom/twitter/macaw/Request;JJ)Lcom/twitter/util/Future;", 3);
    	methodIds.put("finalize()V", 13);
    	methodIds.put("printHello(Ljava/lang/String;)V", 8);
    	methodIds.put("transform(Lcom/twitter/macaw/Request;)Lcom/twitter/util/Future;", 7);
    	methodIds.put("getAccountUserIds(Lcom/twitter/ads/dataservice/client/repositories/Account;)Lscala/collection/Seq;", 5);
    	methodIds.put("clone()Ljava/lang/Object;", 11);
    	methodIds.put("apply(Ljava/lang/Object;Lcom/twitter/finagle/Service;)Lcom/twitter/util/Future;", 1);
    	Map<Integer, String> subclassIdToSubclassImplName = new HashMap<Integer, String>();
    	subclassIdToSubclassImplName.put(1, "com.twitter.androidRepl.gen.M¦Hello¦421");
    	subclassIdToSubclassImplName.put(0, "com.twitter.androidRepl.gen.M¦Hello$ReferenceClass¦421");

    	return new MetadataDiff(subclassIds, fieldIds, methodIds, subclassIdToSubclassImplName);


    }
}
