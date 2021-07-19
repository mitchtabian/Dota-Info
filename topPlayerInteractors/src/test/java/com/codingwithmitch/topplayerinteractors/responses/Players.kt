package com.codingwithmitch.topplayerinteractors.responses

/**
 * Responses from https://api.opendota.com/api/players/{account_id}
 * @property player1 = Good data
 * @property player2 = Good data
 * @property player3 = Good data
 * @property malformedPlayer = Malformed data
 * @property emptyPlayerData = Empty data
 *
 */
object Players {
    val player1 = "{ \"tracked_until\": null, \"solo_competitive_rank\": 4185, \"profile\": { \"account_id\": 268590680, \"personaname\": \"....\", \"name\": null, \"plus\": false, \"cheese\": 0, \"steamid\": \"76561198228856408\", \"avatar\": \"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/fc/fcba662217dbe27de744fa30ddc4fe62ed83b28a.jpg\", \"avatarmedium\": \"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/fc/fcba662217dbe27de744fa30ddc4fe62ed83b28a_medium.jpg\", \"avatarfull\": \"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/fc/fcba662217dbe27de744fa30ddc4fe62ed83b28a_full.jpg\", \"profileurl\": \"https://steamcommunity.com/profiles/76561198228856408/\", \"last_login\": \"2019-10-12T04:46:46.150Z\", \"loccountrycode\": null, \"is_contributor\": false }, \"competitive_rank\": 3829, \"rank_tier\": 80, \"leaderboard_rank\": 1295, \"mmr_estimate\": { \"estimate\": 4347 } }"

    val player2 = "{ \"tracked_until\": null, \"solo_competitive_rank\": null, \"competitive_rank\": null, \"rank_tier\": 80, \"profile\": { \"account_id\": 1051246927, \"personaname\": \"ого, ебало то восстановили BlooT\", \"name\": null, \"plus\": true, \"cheese\": 0, \"steamid\": \"76561199011512655\", \"avatar\": \"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/69/69a59175e799041da4c185b83713dec84d243001.jpg\", \"avatarmedium\": \"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/69/69a59175e799041da4c185b83713dec84d243001_medium.jpg\", \"avatarfull\": \"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/69/69a59175e799041da4c185b83713dec84d243001_full.jpg\", \"profileurl\": \"https://steamcommunity.com/profiles/76561199011512655/\", \"last_login\": null, \"loccountrycode\": null, \"is_contributor\": false }, \"leaderboard_rank\": 4815, \"mmr_estimate\": { \"estimate\": 4083 } }"

    val player3 = "{ \"tracked_until\": null, \"rank_tier\": 80, \"solo_competitive_rank\": 5773, \"profile\": { \"account_id\": 96928450, \"personaname\": \"你开心就好\", \"name\": null, \"plus\": false, \"cheese\": 0, \"steamid\": \"76561198057194178\", \"avatar\": \"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/34/3495a2d38f4b7a69cbed80a5c44c39942c3b84b2.jpg\", \"avatarmedium\": \"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/34/3495a2d38f4b7a69cbed80a5c44c39942c3b84b2_medium.jpg\", \"avatarfull\": \"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/34/3495a2d38f4b7a69cbed80a5c44c39942c3b84b2_full.jpg\", \"profileurl\": \"https://steamcommunity.com/id/hzp3927/\", \"last_login\": null, \"loccountrycode\": null, \"is_contributor\": false }, \"leaderboard_rank\": 268, \"mmr_estimate\": { \"estimate\": 5331 }, \"competitive_rank\": 4803 }"

    val malformedPlayer = "{ \"tracked_until\": null, \"rank_tier\": 80, \"leaderboard_rank\": 12, \"solo_competitive_rank\": 7819, \"mmr_estimate\": { \"estimate\": 6935 }, \"profile\": \"account_id\": 112740723, \"personaname\": \"1pos\", \"name\": null, \"plus\": false, \"cheese\": 0, \"steamid\": \"76561198073006451\", \"avatar\": \"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/95/950a7905dd01f2ad068d8165c8806e27614785b3.jpg\", \"avatarmedium\": \"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/95/950a7905dd01f2ad068d8165c8806e27614785b3_medium.jpg\", \"avatarfull\": \"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/95/950a7905dd01f2ad068d8165c8806e27614785b3_full.jpg\", \"profileurl\": \"https://steamcommunity.com/id/JUKERR/\", \"last_login\": null, \"loccountrycode\": \"RU\", \"is_contributor\": false }, \"competitive_rank\": 5305 }"

    val emptyPlayerData = "{}"
}