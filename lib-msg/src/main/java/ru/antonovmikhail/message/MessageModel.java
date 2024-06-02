package ru.antonovmikhail.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class MessageModel implements Serializable {
    private static final long serialVersionUID = 42424242L;
    @JsonProperty("message")
    private String message;
    @JsonProperty("routing_key")
    private String routingKey;
    @JsonProperty("action_type")
    private String actionType;
    @JsonProperty("personal_key")
    private String personalKey;
}
