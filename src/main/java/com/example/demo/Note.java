package com.example.demo;

import lombok.*;

@Data()
@AllArgsConstructor()
class Note {
    private long id;
    private String title;
    private String content;

}
