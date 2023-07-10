package com.silascandiolli.app;

import java.util.UUID;

public record Customer(UUID uuid, String name, String email)
{
}
