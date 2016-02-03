![BukkitPE](https://gyazo.com/b972ad341bceff44a1eb82a75d9db502.png)


# BukkitPE Contribution Guidelines

## I have a question
* You may use our [Forum](https://forums.bukkitpe.net) to ask questions.
* You may use our [Gitter chat](https://gitter.im/BukkitPE/BukkitPE) to ask questions and comment or socialise.

## Creating an Issue
 - First, visit the [Issue](https://github.com/BukkitPE/BukkitPE/issues) to check if anyone has the same issue as you..
 - If your issue is related to a plugin, you must contact their original author instead of reporting it here.
 - If your issue is related to an BukkitPE official plugin, you must create an issue on that specific repository.
 - Information must be provided in the issue body, not in the title. No tags are allowed in the title, and do not change the title if the issue has been solved.

## Contributing Code
* Use the [Pull Request](https://github.com/BukkitPE/BukkitPE/pull/new) system, your request will be checked and discussed.
* __Create a single branch for that pull request__
* The code must be clear and written in English, comments included.
* Use descriptive commit titles

**Thanks for contributing to BukkitPE!**

## Bug Tracking for Collaborators

### Labels
To provide a concise bug tracking environment, prevent the issue tracker from over flowing and to keep support requests out of the bug tracker, ImagicalMine uses a label scheme a bit different from the default GitHub Issues labels.

BukkitPE uses GitHub Issues Labels. For future reference, labels must not be longer than 15 letters.

#### Categories
Category labels are prefixed by `C:`. Multiple category labels may be applied to a single issue(but try to keep this to a minimum and do not overuse category labels).
 - C: Core - This label is applied when the bug results in a fatal crash, or is related to neither Gameplay nor Plugin API.
 - C: Gameplay - This label is applied when the bug effects the gameplay.
 - C: API - This label is applied when the bug effects the Plugin API.

#### Pull Requests
Pull Requests are prefixed by `PR:`. Only one label may be applied for a Pull Request.
 - PR: Bug Fix - This label is applied when the Pull Request fixes a bug. 
 - PR: Contribution - This label is applied when the Pull Request contributes code to ImagicalMine such as a new feature or an improvement.
 - PR: RFC - Request for Comments

#### Status
Status labels show the status of the issue. Multiple status labels may be applied.
 - Duplicated - This label is applied when the bug has been reproduced, or multiple people are reporting the same issue and symptoms in which case it is automatically assumed that the bug has been reproduced in different environments.
 - Possibly Fixed - This label is applied when the cause of the bug has been found.
 - Critical - This label is applied when the bug is easy to fix, or if the scale of the bug is global.
 - Won't Fix - This label is applied if the bug has been decided not be fixed for some reason. e.g. when the bug benefits gameplay.

### Closing Issues
To keep the bug tracker clear of non-related issues and to prevent it from overflowing, **issues must be closed as soon as possible** (This may sound unethical, but it is MUCH better than having the BUG TRACKER filled with SUPPORT REQUESTS and "I NEED HELP").

If an issue does not conform to the "Creating an Issue" guidelines above, the issue should be closed.
