# SimpleCounter

## AND102 Lab 1 - *Tap Counter*

Submitted by: **Dan Sevalie-Gborie**

**SimpleCounter** is a space-themed Android tap counter, similar to idle tap games. Every tap on the star adds to your total, you can unlock an upgrade that doubles the value of each tap, and you work toward increasingly difficult goals.

## Required Features

The following **required** functionality is completed:

- [x] User can see a number displayed on the screen. The number starts at 0.
- [x] User can tap on a button to see the number displayed increase by 1.

## Optional / Stretch Features

The following **optional** features are implemented:

- [x] User can exchange taps for an upgrade: at 100 taps, an **Upgrade to Add 2** button appears, and after tapping it every tap counts as 2
- [x] App is customized with a **space theme**: a starry night-sky background and a gold star icon as the tap button
- [x] (Extra challenge) User has increasingly difficult goals to reach (10, 50, 100, 250, 500, 1000, then doubling). The current goal is shown on screen, along with how many goals have been reached in total
- [x] A Toast message appears when a goal is reached and when the upgrade is unlocked

## Video Walkthrough

Here's a walkthrough of the implemented features:

(https://youtube.com/shorts/FHYJK4jDqUw?feature=share) [Watch The Video]

<!-- Replace the src above with a link to your .gif, or drag the .gif into this README on GitHub -->

## Tech Stack

- **Kotlin** / Android
- **ConstraintLayout** for the screen layout
- **Toasts** for feedback messages
- Vector drawables for the themed background and star button

## Setup

1. Clone this repository and open it in Android Studio.
2. Let Gradle finish syncing.
3. Build and run on an emulator or device (Android 7.0 / API 24 or newer).

## Notes

The upgrade is handled with a `tapValue` variable that starts at 1 and becomes 2 after the upgrade, so the same click listener keeps tracking goals after the upgrade instead of being replaced.

## License

    Copyright 2026 Dan Sevalie-Gborie

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
