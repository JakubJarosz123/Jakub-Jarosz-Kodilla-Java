package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User wiesiek = new Millenials("Wiesław Boniek");
        User emilka = new YGeneration("Emilka Rzykowska");
        User brajanek = new ZGeneration("Brajan Lewnadowski");

        //When
        String wiesiekSharedPost = wiesiek.sharePost();
        System.out.println("Wieśka shared post on: " +  wiesiekSharedPost);
        String emilkiSharedPost = emilka.sharePost();
        System.out.println("Emilki shared post on: " +  emilkiSharedPost);
        String brajanekSharedPost = brajanek.sharePost();
        System.out.println("Brajanka shared post on: " +  brajanekSharedPost);

        //Then
        assertEquals("Facebook", wiesiekSharedPost);
        assertEquals("Twitter", emilkiSharedPost);
        assertEquals("Snapchat", brajanekSharedPost);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User emilka = new YGeneration("Emilka Rzykowska");

        //When
        String emilkiSharedPost = emilka.sharePost();
        System.out.println("Emilki shared post on: " +  emilkiSharedPost);
        emilka.setSocialPublisher(new SnapchatPublisher());
        emilkiSharedPost = emilka.sharePost();
        System.out.println("Emilki now shared post on: " +  emilkiSharedPost);

        //Then
        assertEquals("Snapchat", emilkiSharedPost);
    }
}
