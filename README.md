# XKCDMvpProject
Project based on XKCD api
I tried to stay clean architecture and separated layers via android modules.
Used MVVM pattern as most reliable and suitable, dagger2 for DI and coroutines for async tasks. I used live data because for now I'm not greate specialist into channels or flows.
Ideally, application must have in addition:
  - diff util callbacks for lists and item decorator
  - comic details screen (user can access from favourite)
  - removing from favourite functionallity
  - depper error handling
