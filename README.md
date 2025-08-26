## Introduction
OpenEmbedded/Yocto Project layer for Radxa Dragon boards based on Qualcomm platforms.

This layers provides aditional recipes and machine configuration files for Qualcomm platform.

This layer depends on:

| URI    | Branch |
| -------- | ------- |
| https://git.yoctoproject.org/meta-qcom | scarthgap |
| https://github.com/openembedded/meta-openembedded | scarthgap |
| https://git.yoctoproject.org/poky | scarthgap |
| https://git.yoctoproject.org/meta-security | scarthgap |
| https://git.yoctoproject.org/meta-virtualization | scarthgap |
| https://github.com/qualcomm-linux/meta-qcom-distro | scarthgap |
| https://github.com/qualcomm-linux/meta-qcom-hwe | scarthgap |

## List of Radxa Boards supported

### QCS6490

* Dragon Q6A

## Build an image for the machine added
```bash
MACHINE="qcs6490-dragon-q6a" DISTRO="qcom-wayland" source setup-environment
bitbake qcom-multimedia-image
```
'qcom-wayland' DISTRO and 'qcom-multimedia-image' are defined in meta-qcom-distro layer.

## Flashing the images on the device
Flash the images on the device using qdl tool.

## Known Issues


## Maintainer(s)
1. Stephen Chen <stephen@radxa.com>
