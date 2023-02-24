package com.card.game.cardstun.model;

import lombok.Data;

/**
 * @ClassName: Message
 * @Description: TODO
 * @auther: cunzhiwang
 */
@Data
public class Message {

    public static final String TYPE_COMMAND_ROOM_ENTER = "enterRoom";
    public static final String TYPE_COMMAND_ROOM_LIST = "roomList";
    public static final String TYPE_COMMAND_DIALOGUE = "dialogue";
    public static final String TYPE_COMMAND_READY = "ready";
    public static final String TYPE_COMMAND_OFFER = "offer";
    public static final String TYPE_COMMAND_ANSWER = "answer";
    public static final String TYPE_COMMAND_CANDIDATE = "candidate";
    public static final String TYPE_COMMAND_CREATE="createRoom";

    private String command;
    private String userId;
    private String roomId;
    private String message;

}
