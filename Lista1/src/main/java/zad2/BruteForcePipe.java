package zad2;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;

public class BruteForcePipe {

    private final String iv;
    private final String key_ending;
    private final String cipher;

    public BruteForcePipe(String iv, String key_ending, String cipher) {
        this.iv = iv;
        this.key_ending = key_ending;
        this.cipher = cipher;
    }

    public void subcribe(String[] keys) {
        Flowable.fromArray(keys)
                .flatMap(key -> Flowable.just(key)
                        .subscribeOn(Schedulers.computation())
                        .map(emmitedKey -> decrypt(emmitedKey))
                ).subscribe(val -> System.out.println(val));
    }

    private String decrypt(String emittedKey) {
        return emittedKey;
    }

}
