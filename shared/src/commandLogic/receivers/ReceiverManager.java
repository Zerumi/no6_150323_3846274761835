package commandLogic.receivers;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ReceiverManager {
    private static final LinkedHashMap<ReceiverType, ArrayList<ExternalBaseReceiver>> receivers; // TODO: Argument Receiver? How to provide args above base receiver

    static {
        receivers = new LinkedHashMap<>();

        for (var type : ReceiverType.values()) {
            receivers.put(type, new ArrayList<>());
        }
    }

    public static void registerReceiver(ReceiverType type, ExternalBaseReceiver receiver) {
        receivers.get(type).add(receiver);
    }

    public static ArrayList<ExternalBaseReceiver> getReceivers(ReceiverType type) {
        return receivers.get(type);
    }
}
