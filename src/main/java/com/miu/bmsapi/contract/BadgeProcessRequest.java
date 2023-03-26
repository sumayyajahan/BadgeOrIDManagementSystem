package com.miu.bmsapi.contract;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Calendar;

@Data
@AllArgsConstructor
public class BadgeProcessRequest {
    private int badgeId;
    private int planId;
    private int locationId;
    private int checkerId;
    private Calendar calendar;
}
