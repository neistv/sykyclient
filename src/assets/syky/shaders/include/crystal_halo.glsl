// The glow round Target ESP's crystals, folded into one quad: two nested copies of one curve, the inner at two thirds
// the radius of the outer. The pair is the point — a single gaussian bends once, so it reads either as a tight ring
// round the core or as a flat wash with nothing in the middle of it, and two of them bend the falloff twice, which is
// the shape the eye reads as light coming off something rather than as a disc painted soft at the edge.
//
// Shared by the mote field (dust_field.fsh), the sprays and trails (burst.fsh) and the loot beams (loot_beam.fsh): one
// look for every syky light, tuned once.

const float HALO_WIDE_GAIN = 0.55;

const float HALO_NARROW_GAIN = 0.55;

// Where the inner halo runs out, as the reciprocal square of its radius: (3/2)^2.
const float HALO_NARROW_SPAN = 2.25;

// Falloffs of the two — the ESP glow layer's own core curve, read at the two radii.
const float HALO_WIDE_FALLOFF = 0.87;

const float HALO_NARROW_FALLOFF = 1.96;

// The halo at `d2`, the squared distance from its centre as a share of its quad's radius (0..1).
//
// The outer halo's window is a smoothstep rather than a plain square. Both land on the quad's edge with zero slope,
// which is what keeps a rim from appearing there, but the square spends its whole budget near the middle and is
// already down to a fortieth of the peak at four fifths of the way out. The smoothstep holds between one and a half
// and two and a half times as much light across that outer half, so the glow reads noticeably wider for exactly the
// same pixels. The inner halo keeps the plain square and is windowed at its OWN radius, so it ends inside the outer
// one rather than being stretched across it — what leaves the falloff its second bend.
float crystalHalo(float d2) {
    float window = max(1.0 - d2, 0.0);
    float inner = max(1.0 - d2 * HALO_NARROW_SPAN, 0.0);
    return HALO_WIDE_GAIN * exp(-HALO_WIDE_FALLOFF * d2) * window * window * (3.0 - 2.0 * window)
            + HALO_NARROW_GAIN * exp(-HALO_NARROW_FALLOFF * d2) * inner * inner;
}
