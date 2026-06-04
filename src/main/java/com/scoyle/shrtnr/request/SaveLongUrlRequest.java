package com.scoyle.shrtnr.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveLongUrlRequest {

    private String longUrl;
}
